package com.test;

import com.training.spring.IMyInt;

public class MyImpl3 implements IMyInt {

	private String str;
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String execute() {
		return str;
	}

}
