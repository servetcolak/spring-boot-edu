package com.training.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.aop.MyCallee;

@RestController
@RequestMapping("/aspect")
public class MyAspectRest {

	@Autowired
	private MyCallee callee;

	@RequestMapping("/call")
	public String myAspectTest(String name) {
		String response = callee.helloTest(name);
		return response;
	}
}
