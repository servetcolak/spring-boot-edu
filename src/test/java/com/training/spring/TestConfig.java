package com.training.spring;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;

@Configuration
public class TestConfig {

	@Bean
	public RestOperations myRestTemplate(RestTemplateBuilder builder) {
		return builder.basicAuthorization("servet3", "1234").build();
	}
	
}
