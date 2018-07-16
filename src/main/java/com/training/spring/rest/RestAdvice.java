package com.training.spring.rest;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.spring.exception.MyException;
import com.training.spring.model.ErrorObj;

@RestControllerAdvice
public class RestAdvice {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public ErrorObj handleException(MyException exception) {
		ErrorObj errorObj = new ErrorObj(exception.getMsg(), exception.getCode());
		return errorObj;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(ValidationException.class)
	public ErrorObj handleException2(ValidationException exception) {
		ErrorObj errorObj = new ErrorObj(exception.getMessage(), 11);
		return errorObj;
	}

}
