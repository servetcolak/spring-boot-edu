package com.training.spring.concurrency;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;

public class ConcurrentTest {

	@Async("executor")
	public ListenableFuture<String> testAsync(String str) {

		try {
			Thread.sleep(1_000);
			str = "ListenableFuture " + str;
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new AsyncResult<String>(str);
	}

	@Async("executor")
	public CompletableFuture<String> testCompletableAsync(String str) {

		try {
			Thread.sleep(1_000);
			str = "CompletableFuture " + str;
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return CompletableFuture.completedFuture(str);
	}

}
