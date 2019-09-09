package com.jf.jf_smartsite.IOTData.entity.comEntity;

import java.io.Serializable;

/**
 * 用于返回给页面的结果提示信息
 * @author 欧Sir
 *
 */
public class Result implements Serializable{
	/**
	 * 是否成功
	 */
	private boolean success;
	
	/**
	 * 提示信息
	 */
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Result(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public Result() {
		// TODO Auto-generated constructor stub
	}
	
}
