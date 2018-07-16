package com.training.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("mehmet")
public class MyImpl2 implements IMyInt{

	@Override
	public String execute() {
		return "My implementation2";
	}

}
