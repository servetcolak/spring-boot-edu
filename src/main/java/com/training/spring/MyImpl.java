package com.training.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("osman")
public class MyImpl implements IMyInt{

	@Override
	public String execute() {
		return "My implementation";
	}

}
