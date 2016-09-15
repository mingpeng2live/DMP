package com.pm.dmp.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * map bean 之间转换
 * @author hongfu.zhang
 *
 */
@SuppressWarnings("unchecked")
public class MapBeanUtils {
	protected static final Logger logger = LoggerFactory.getLogger(MapBeanUtils.class);
	
	
	public static Map<String, Object> describe(Object bean) {
        if (bean == null) {
            return (new java.util.HashMap<String, Object>(0));
        }
        try {
			return PropertyUtils.describe(bean);
		} catch (Exception e) {
			logger.error( e.getMessage() , e );
			return MapUtils.EMPTY_MAP;
		}

    }
	
	public static Map<String, String> beanToMap(Object obj){
		try {
			return BeanUtils.describe(obj);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			logger.error( e.getMessage() , e );
			return MapUtils.EMPTY_MAP;
		}
	}
	
	public static <T> T mapToBean(Map<String, ? extends Object> map, Class<T> _class) {  
        T bean = null;  
        try {  
            bean = _class.newInstance();  
            BeanUtils.populate(bean, map); 
        } catch (Exception e) {  
            e.printStackTrace();
            logger.error(e.getMessage() ,e );
        } 
        return bean;  
    }  
}
