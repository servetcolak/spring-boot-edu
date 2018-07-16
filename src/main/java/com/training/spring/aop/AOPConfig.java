package com.training.spring.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {
	
	@Bean
	public Caller createCaller() {
		return new Caller();
	}
	
	@Bean
	public Callee createCallee() {
		return new Callee();
	}
	
	@Bean
	public MyCallee createCalleeTest() {
		return new MyCallee();
	}
	
}
