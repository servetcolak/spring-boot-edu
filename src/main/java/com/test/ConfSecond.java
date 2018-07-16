package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.training.spring.IMyInt;

@Configuration
public class ConfSecond {
	
	@Bean
	public IMyInt createMyIntTest() {
		return new MyImpl3();
	}

}
