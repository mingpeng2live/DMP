package com.pm.dmp.rest;

import java.io.IOException;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
  
/**
 * 重写spring mvc 的json化过程
 * 
 * @author rocca.peng@hunteron.com
 * @Description 
 * @Date  2015年8月6日 上午9:41:30
 */
public class Jackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {  
  
    @Override  
    protected void writeInternal(Object object, HttpOutputMessage outputMessage)  
            throws IOException, HttpMessageNotWritableException {  
        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());  
        JsonGenerator generator = objectMapper.getFactory().createGenerator(outputMessage.getBody(), encoding);  
  
        writePrefix(generator, object);
		Class<?> serializationView = null;
		Object value = object;
		if (value instanceof MappingJacksonValue) {
			MappingJacksonValue container = (MappingJacksonValue) object;
			value = container.getValue();
			serializationView = container.getSerializationView();
		}
		if (serializationView != null) {
			objectMapper.writerWithView(serializationView).writeValue(generator, value);
		} else {
			if (!(value instanceof RestResponse)) {
				RestResponse result = new RestResponse();
				result.setData(value);
				value = result;
			}
			objectMapper.writeValue(generator, value);
		}
		writeSuffix(generator, object);
		generator.flush();
    }

    public void setPrefixJson(boolean prefixJson) {  
        super.setPrefixJson(prefixJson);
    }  
  
}  