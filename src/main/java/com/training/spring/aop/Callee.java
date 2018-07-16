package com.training.spring.aop;

public class Callee {

	public String hello(String str) throws Exception {
		System.out.println("hello metodu calisti " + str);
		if ("world".equals(str)) {
			throw new Exception();
		}

		return "hello" + str;
	}

	@LogAt(extraData = "helloTest metoduna geldi!!!")
	public String helloTest(String str) {
		System.out.println("helloTest metodu calisti " + str);
		return "hello" + str;
	}
}
