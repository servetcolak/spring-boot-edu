package com.training.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAOPEnforcer {

	private static final Logger logger = LoggerFactory.getLogger(MyAOPEnforcer.class);

	@Around("within(com.training.spring.aop.MyCallee) && @annotation(log)")
	public Object callBeforeProceed(ProceedingJoinPoint jp, LogAt log) {
		try {
			Object[] args = jp.getArgs();
			String name = (String) args[0];

			if (!"servet".equals(name.toLowerCase())) {
				name = "Servet";
			}
			args[0] = name;

			logger.info(name);
			Object obj = jp.proceed(args);
			logger.info("After proceeding: " + (String) obj);

			return obj;

		} catch (Throwable e) {

		}

		return null;
	}
}
