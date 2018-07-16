package com.training.spring.condition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Conditional;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;;

@Target({ METHOD, TYPE, FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Conditional(MyCondition.class)
public @interface MyConditionAno {

	String name() default "";

	int age();
}
