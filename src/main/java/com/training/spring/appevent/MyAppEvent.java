package com.training.spring.appevent;

import org.springframework.context.ApplicationEvent;

public class MyAppEvent extends ApplicationEvent {

	private String message;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyAppEvent() {
		super(MyAppEvent.class);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
