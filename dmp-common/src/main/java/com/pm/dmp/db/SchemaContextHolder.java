package com.pm.dmp.db;

/**
 * 多个登录用户可能需要同时切换数据源，所以这里需要写一个线程安全的ThreadLocal
 * 用户切换数据源只要在程序中使用 SchemaContextHolder.setSchema(schema) 即可完成数据源切换
 * @author pengming
 * @Date  2015年10月30日 上午10:12:24
 */
public class SchemaContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setSchema(String schema) {
		contextHolder.set(schema);
	}

	public static String getSchema() {
		return (String) contextHolder.get();
	}

	public static void clearSchema() {
		contextHolder.remove();
	}
}