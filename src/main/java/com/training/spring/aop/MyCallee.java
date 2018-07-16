package com.training.spring.aop;

public class MyCallee {
	
	@LogAt(extraData = "helloTest metoduna geldi!!!")
	public String helloTest(String str) {
		System.out.println("helloTest metodu calisti " + str);
		return "Hello " + str;
	}
	
}
