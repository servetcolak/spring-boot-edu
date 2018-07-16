package com.training.spring.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealth implements HealthIndicator{

	@Override
	public Health health() {
		Health health = Health.status(Status.DOWN).build();
		return health;
	}

}