package com.training.spring.appevent;

import org.springframework.context.event.EventListener;

//@Component
public class EventListenerWithAno {

	@EventListener
	public void handleEvent(MyAppEvent event) {
		System.out.println("Application event with anotation! Message: " + event.getMessage());
	}
}
