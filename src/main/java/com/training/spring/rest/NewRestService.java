package com.training.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.IMyInt;
import com.training.spring.config.MyAnnotation;

@RestController
public class NewRestService {
	
	@Autowired
	@MyAnnotation
	private IMyInt myInt;
	
	@RequestMapping("/run")
	public String testAnnotation() {
		return myInt.execute();
	}

}
