package com.pm.dmp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.pm.dmp.rest.MessageSourceUtils;
import com.pm.dmp.rest.RestResponse;
import com.pm.dmp.util.JackSonSerializer;

/**
 *
 * @author pengming
 * @Date  2015年11月3日 下午5:31:46
 */
public class ReqFilter implements Filter {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());	
		MessageSourceUtils.setApplicationContext(context);
		logger.info(" filter init ......");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			res.setHeader("Transfer-Encoding", "utf-8");
			res.setHeader("Content-Type", "application/json;charset=utf-8");
			
			chain.doFilter(req, res);
		} catch (Exception e) {
			logger.error("服务出错误", e);
		}
	}


	public void writerError(ServletResponse response, RestResponse entity) throws IOException {
		String result =  JackSonSerializer.toStringNException(entity);
		PrintWriter writer = response.getWriter();
		writer.write(result);
		writer.flush();
	}

}
