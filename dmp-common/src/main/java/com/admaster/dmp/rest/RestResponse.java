package com.admaster.dmp.rest;

/**
 * 返回统一标准实体
 *
 * @author pengming
 * @Date  2016年1月27日 下午4:34:14
 */
public class RestResponse {
	
	private Object data;
	private String errMsg;
	private String errCode;
	private String errDesc;
	private Boolean success = true;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrDesc() {
		return errDesc;
	}

	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	
	
}
