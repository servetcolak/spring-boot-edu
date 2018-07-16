package com.training.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.training.spring.IMyInt;
import com.training.spring.MyImpl2;

@Profile("prod")
@Configuration
public class ProdConfig {

	@Bean
	@MyAnnotation
	public IMyInt devInterface() {
		return new MyImpl2();
	}
	
}
