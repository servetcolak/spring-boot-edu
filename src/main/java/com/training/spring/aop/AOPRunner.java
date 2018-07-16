package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AOPRunner implements CommandLineRunner {

	@Autowired
	private Caller caller;
	
	@Override
	public void run(String... args) throws Exception {
		caller.call();
	}

}
