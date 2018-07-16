package com.training.spring.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
//@EnableScheduling
public class AsyncConf {

	@Bean
	public Executor executor() {
		return Executors.newFixedThreadPool(10);
	}

	@Bean
	public ConcurrentTest createCuncurrentTest() {
		return new ConcurrentTest();
	}

	// @Scheduled(initialDelay = 2000, fixedDelay = 1000)
	// public void runMe() {
	// System.out.println("TIME :" + new Date().getTime());
	// }

}
