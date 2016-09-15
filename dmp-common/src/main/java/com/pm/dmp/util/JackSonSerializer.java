package com.pm.dmp.util;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * jackSon的序列器和反序列器
 * 
 * 
 */
@SuppressWarnings("all") 
public class JackSonSerializer {

	private static ObjectMapper m = new ObjectMapper();

	public static <T> T toBean(String jsonAsString, Class<T> pojoClass)
			throws JsonGenerationException {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			m.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			m.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			m.setDateFormat(df);
			return m.readValue(jsonAsString, pojoClass);
		} catch (Exception e) {
			throw new JsonGenerationException(e);
		}
	}

	public static String toString(Object pojo) throws JsonGenerationException {
		try {
			StringWriter sw = new StringWriter();
			m.writeValue(sw, pojo);
			return sw.toString();
		} catch (Exception e) {
			throw new JsonGenerationException(e);
		}
	}
	
	public static String toStringNException(Object pojo) {
		try {
			StringWriter sw = new StringWriter();
			m.writeValue(sw, pojo);
			return sw.toString();
		} catch (Exception e) {
		}
		return null;
	}
	
	public static String toStringNException(Object pojo, String defaultStr) {
		try {
			StringWriter sw = new StringWriter();
			m.writeValue(sw, pojo);
			return sw.toString();
		} catch (Exception e) {
		}
		return defaultStr;
	}

	public static <T> Map<String, T> toMap(String jsonAsString)
			throws JsonGenerationException {
		try {
			return m.readValue(jsonAsString,
					new TypeReference<Map<String, T>>() {
					});
		} catch (Exception e) {
			throw new JsonGenerationException(e);
		}
	}

	public static <T> Map<String, T>[] toMapArray(String jsonAsString)
			throws JsonGenerationException {
		try {
			return m.readValue(jsonAsString,
					new TypeReference<Map<String, T>[]>() {
					});
		} catch (Exception e) {
			throw new JsonGenerationException(e);
		}
	}
	
	public static <T> List<T> toList(String jsonAsString ,Class<T> c ) throws JsonGenerationException{
		List<T> list =  new ArrayList<T>();
		try {
			list = m.readValue(jsonAsString,getCollectionType(ArrayList.class, c));
		} catch (Exception e) {
			throw new JsonGenerationException(e);
		}
		return list ; 
	} 
	
	private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {   
		return m.getTypeFactory().constructParametricType(collectionClass, elementClasses);   
	} 

}
