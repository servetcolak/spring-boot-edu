package com.training.spring;

import org.springframework.stereotype.Component;

@Component
public class MyObject {
	
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
