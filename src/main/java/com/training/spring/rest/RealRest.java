package com.training.spring.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.exception.MyException;
import com.training.spring.model.ErrorObj;
import com.training.spring.model.Person;

@Validated
@RestController
@RequestMapping("/real")
public class RealRest {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ErrorObj handleException(MyException exception) {
		ErrorObj errorObj = new ErrorObj(exception.getMsg(), exception.getCode());
		return errorObj;
	}

	@RequestMapping("/r1")
	public Person processPerson(@RequestParam("name") String name, @RequestParam("age") int age) throws MyException {
		if (age < 10 || age > 120) {
			throw new MyException("Yaş 10 ile 120 arasında olmalıdır!", 1);
		}
		Person person = new Person();
		person.setAge(age);
		person.setName(name);
		return person;
	}

	@RequestMapping("/r2")
	public Person processPerson2(@NotNull @Size(min = 2, max = 10, message= "Hayır olamaz!") @RequestParam("name") String name,
			@Max(120) @Min(10) @RequestParam("age") int age) {
		Person person = new Person();
		person.setAge(age);
		person.setName(name);
		return person;
	}

	@RequestMapping("/r3")
	public ResponseEntity<?> processPerson3(@RequestParam("name") String name, @RequestParam("age") int age) {

		ResponseEntity<?> entity = null;
		if (age < 10 || age > 120) {
			entity = ResponseEntity.status(475).body(new ErrorObj("10 ile 120 arasında olmalı", 475));
		} else {
			Person person = new Person();
			person.setAge(age);
			person.setName(name);
			entity = ResponseEntity.ok(person);
		}
		return entity;
	}
	
	@RequestMapping("/r4")
	public ResponseEntity<?> processPerson4(HttpServletRequest request, HttpServletResponse response) {

		int age = Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("name");
		
		ResponseEntity<?> entity = null;
		if (age < 10 || age > 120) {
			entity = ResponseEntity.status(475).body(new ErrorObj("10 ile 120 arasında olmalı", 475));
		} else {
			Person person = new Person();
			person.setAge(age);
			person.setName(name);
			entity = ResponseEntity.ok(person);
		}
		return entity;
	}
	
	@RequestMapping("/r5")
	public void processPerson5(HttpServletRequest request, HttpServletResponse response) throws IOException {

		int age = Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("name");
		
		response.getOutputStream().print("age: " + age + ", name: " + name);
	}


}
