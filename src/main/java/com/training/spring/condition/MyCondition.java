package com.training.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

public class MyCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		MultiValueMap<String, Object> multiValueMap = metadata
				.getAllAnnotationAttributes(MyConditionAno.class.getName());
		// String name = (String) multiValueMap.getFirst("name");
		int age = (int) multiValueMap.getFirst("age");

		if (age > 100) {
			return true;
		}

		return false;
	}

}
