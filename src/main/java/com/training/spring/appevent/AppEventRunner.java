package com.training.spring.appevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Component;

@Component
public class AppEventRunner implements CommandLineRunner {

	@Autowired
//	@Qualifier("myMulti")
	private ApplicationEventMulticaster aem;

	@Override
	public void run(String... args) throws Exception {
		MyAppEvent appEvent = new MyAppEvent();
		appEvent.setMessage("Hello other module!!");
		aem.multicastEvent(appEvent);
	}

}
