package com.training.spring;

import org.springframework.boot.SpringApplication;

public class Runner {
	public static void main(String[] args) {
		//ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		SpringApplication.run(SpringbootApplication.class, args);
		//SpringbootApplication application = context.getBean(SpringbootApplication.class);
		//System.out.println(application.myObject);
	}
}
