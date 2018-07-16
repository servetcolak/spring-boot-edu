package com.training.spring.concurrency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class AsyncRunner implements CommandLineRunner {

	@Autowired
	private ConcurrentTest ct;

	// @Override
	// public void run(String... args) throws Exception {
	// System.out.println("Start...");
	// CompletableFuture<String> cf = ct.testCompletableAsync("Test");
	// System.out.println("process1...");
	// System.out.println("process2...");
	//
	// if (!cf.isDone()) {
	// System.out.println("process3...");
	// System.out.println("process4...");
	// }
	//
	// String resp = cf.get();
	// System.out.println("CompletableFuture response: " + resp);
	// }

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Start...");
		ListenableFuture<String> lf = ct.testAsync("Test");
		lf.addCallback(new ListenableFutureCallback<String>() {

			@Override
			public void onSuccess(String result) {
				System.out.println("process1...");
				System.out.println("process2...");
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("process3...");
				System.out.println("process4...");
			}

		});

		/*
		 * CompletableFuture<String> cf = ct.testCompletableAsync("Test");
		 * System.out.println("CompletableFuture start...");
		 * 
		 * while(!cf.isDone()) { System.out.println("CompletableFuture not completed!");
		 * }
		 * 
		 * System.out.println("CompletableFuture completed..." + cf.get());
		 */

	}

}
