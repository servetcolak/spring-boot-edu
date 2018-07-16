package com.training.spring.appevent;

import org.springframework.boot.actuate.audit.listener.AuditApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerAuth {

	@EventListener
	public void handleEvent(AuditApplicationEvent event) {
		System.out.println("Application Audit Events : " +event.getAuditEvent());
	}

}
