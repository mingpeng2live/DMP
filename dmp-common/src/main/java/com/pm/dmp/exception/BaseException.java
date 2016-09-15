package com.pm.dmp.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * 业务异常父类
 * 
 * @author pengming
 * @Date 2016年1月28日 下午2:36:55
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;
	private String errorCode;
	private BaseErrorInfo errorInfo;

	public BaseException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public BaseException(String errorCode, String message, Throwable ex) {
		super(message, ex);
		this.errorCode = errorCode;
	}

	public BaseException(BaseErrorInfo errorInfo) {
		super(errorInfo.getErrMessage());
		this.errorInfo = errorInfo;
		this.errorCode = errorInfo.getErrCode();
	}
	
	public BaseException(BaseErrorInfo errorInfo, Throwable ex) {
		super(errorInfo.getErrMessage(), ex);
		this.errorInfo = errorInfo;
		this.errorCode = errorInfo.getErrCode();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

	public BaseErrorInfo getErrorInfo() {
		return errorInfo;
	}

	/** 覆盖原本抛出的异常信息 */
	public void setErrorInfo(BaseErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
		if (errorInfo != null) {
			this.errorCode = errorInfo.getErrCode();
			this.message = errorInfo.getErrMessage();
		}
	}

	/**
	 * 判断当前异常中是否设置异常信息，如果无，则获取异常原本的异常信息
	 */
	@Override
	public String getMessage() {
		return StringUtils.isNotEmpty(this.message) ? this.message : super.getMessage();
	}
	
}
