package com.pm.dmp.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.pm.dmp.rest.RestResponse;

/**
 * 统一异常处理类，将异常以JSON形式返回给用户
 *
 * @author pengming
 * @Date  2016年1月29日 下午12:31:19
 */
@SuppressWarnings("all")
public class BaseHandlerExceptionResolver extends AbstractHandlerExceptionResolver implements InitializingBean {

	private final static Logger logger = LoggerFactory.getLogger(BaseHandlerExceptionResolver.class);
	
	/** 控制异常返回结果中是否输出堆栈信息， 默认false，不输出*/
	private boolean stackTrace = false;
	
	private HttpMessageConverter<?>[] messageConverters = null;
	private List<HttpMessageConverter<?>> allMessageConverters = null;

	public void setStackTrace(boolean stackTrace){
		this.stackTrace = stackTrace;
	}
	
	public void setMessageConverters(HttpMessageConverter<?>[] messageConverters) {
		this.messageConverters = messageConverters;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		ensureMessageConverters();
	}

	private void ensureMessageConverters() {
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		// user configured values take precedence:
		if (this.messageConverters != null && this.messageConverters.length > 0) {
			converters.addAll(CollectionUtils.arrayToList(this.messageConverters));
		}
		// defaults next:
		new HttpMessageConverterHelper().addDefaults(converters);
		this.allMessageConverters = converters;
	}

	// leverage Spring's existing default setup behavior:
	private static final class HttpMessageConverterHelper extends WebMvcConfigurationSupport {
		public void addDefaults(List<HttpMessageConverter<?>> converters) {
			addDefaultHttpMessageConverters(converters);
		}
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		// 异常日志统一在这里记录
		logger.error("", ex);
		ServletWebRequest webRequest = new ServletWebRequest(request, response);
		RestResponse result = new RestResponse();
		if (ex instanceof BaseException) {
			BaseException baseException = (BaseException)ex;
			result.setErrCode(baseException.getErrorCode());
			result.setSuccess(false);
			result.setErrMsg(baseException.getMessage());
		} else {
			result.setSuccess(false);
			result.setErrMsg(ex.getMessage());
		}
		if (stackTrace) {
			result.setErrDesc(getStackTrace(ex));
		}
		ModelAndView mv = null;
		try {
			mv = handleResponseBody(result, webRequest);
		} catch (ServletException | IOException invocationEx) {
			logger.error("Acquiring ModelAndView for Exception [" + ex + "] resulted in an exception.", invocationEx);
		}
		return mv;// 如果自己处理不了，return null让其他的ExceptionResolver处理。
	}
	
	/**
     * 将异常堆栈转换为字符串
     * @param exception 异常
     * @return String
     */
    public static String getStackTrace(Throwable exception) {
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        exception.printStackTrace(printWriter);
        return result.toString();
    }

	private ModelAndView handleResponseBody(Object body, ServletWebRequest webRequest) throws ServletException, IOException {
		HttpInputMessage inputMessage = new ServletServerHttpRequest(webRequest.getRequest());
		List<MediaType> acceptedMediaTypes = inputMessage.getHeaders().getAccept();
		if (acceptedMediaTypes.isEmpty()) {
			acceptedMediaTypes = Collections.singletonList(MediaType.ALL);
		}
		MediaType.sortByQualityValue(acceptedMediaTypes);
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(webRequest.getResponse());
		Class<?> bodyType = body.getClass();
		List<HttpMessageConverter<?>> converters = this.allMessageConverters;
		if (converters != null) {
			for (MediaType acceptedMediaType : acceptedMediaTypes) {
				for (HttpMessageConverter messageConverter : converters) {
					if (messageConverter.canWrite(bodyType, acceptedMediaType)) {
						messageConverter.write(body, acceptedMediaType, outputMessage);
						return new ModelAndView(); // 此处返回空对象，表明已处理，不再需要其他异常处理器去处理
					}
				}
			}
		}
		if (logger.isWarnEnabled()) {
			logger.warn("Could not find HttpMessageConverter that supports return type [" + bodyType + "] and " + acceptedMediaTypes);
		}
		return null; // 表明当前异常处理器未能处理， 需要其他异常处理器处理
	}

}