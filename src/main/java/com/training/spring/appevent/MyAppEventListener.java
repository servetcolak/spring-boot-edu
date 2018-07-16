package com.training.spring.appevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyAppEventListener implements ApplicationListener<MyAppEvent> {

	@Override
	public void onApplicationEvent(MyAppEvent event) {
		System.out.println("Event Message: " + event.getMessage());
	}

}
