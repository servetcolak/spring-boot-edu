package com.training.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPEnforcer {

	// @Pointcut("execution(* com.training.spring.aop.Callee.*(..)) && args(str)")
	@Pointcut("execution(* com.training.spring.aop.Callee.hello(..)) && args(str)")
	public void myMethod(String str) {

	}

	// @Before("execution(* com.training.spring.aop.Callee.*(..) && args(str))")
	@Before("myMethod(str)")
	public void beforeCaller(JoinPoint jp, String str) {
		System.out.println(jp.toLongString());
		System.out.println("beforeCaller " + str);
	}

	// @After("execution(* com.training.spring.aop.Callee.*(..) && args(str))")
	@After("myMethod(str)")
	public void afterCaller(JoinPoint jp, String str) {
		System.out.println(jp.toLongString());
		System.out.println("afterCaller " + str);
	}

	@AfterReturning(pointcut = "myMethod(str)", returning = "retStr")
	public void afterCallerReturning(JoinPoint jp, String str, String retStr) {
		System.out.println(jp.toLongString());
		System.out.println("afterCallerReturning cagrildi " + retStr);
	}

	@AfterThrowing(pointcut = "myMethod(str)", throwing = "ex")
	public void afterExceptionMethod(JoinPoint jp, String str, Exception ex) {
		System.out.println(jp.toLongString());
		System.out.println("afterExceptionMethod cagrildi " + ex.getStackTrace());
	}

	@Around("myMethod(str)")
	public Object arroundInv(ProceedingJoinPoint jp, String str) {
		try {
			Object[] args = jp.getArgs();
			String strA = (String) args[0];
			strA += " Test";
			args[0] = strA;

			Object obj = jp.proceed(args);
			str = (String) obj;
			str = "Around ek: " + str;
			return str;
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return null;
	}

	@Around("within(com.training.spring.aop.Callee) && @annotation(log)")
	public Object arroundInv(ProceedingJoinPoint jp, LogAt log) {
		try {
			Object[] args = jp.getArgs();
			String strA = (String) args[0];
			strA += " Test";
			args[0] = strA;

			logger.info("join point : " + jp.toLongString() + " extra: " + log.extraData());

			Object obj = jp.proceed(args);
			String str = (String) obj;
			str = "Around ek: " + str;
			
			return str;
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return null;
	}

	private static final Logger logger = LoggerFactory.getLogger(AOPEnforcer.class);

}
