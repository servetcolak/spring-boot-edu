package com.training.spring.model;

public class ErrorObj {
	private String msg;
	private int code;
	
	
	public ErrorObj(String msg, int code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
}
