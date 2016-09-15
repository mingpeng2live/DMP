package com.pm.dmp.exception;

/**
 * 异常信息父接口
 * 
 * 自定义枚举、实现类实现该接口
 * 
 * @author pengming
 * @Date  2016年1月29日 下午2:59:33
 */
public interface BaseErrorInfo {

	/** 错误码 */
	String getErrCode();
	
	/** 错误信息 */
	String getErrMessage();
	
}
