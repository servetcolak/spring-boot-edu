package com.training.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class Caller {

	@Autowired
	private Callee callee;

	public void call() throws Exception {

		String hello = callee.helloTest("world");
		System.out.println(hello);

	}
}
