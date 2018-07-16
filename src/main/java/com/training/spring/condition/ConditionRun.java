package com.training.spring.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.training.spring.model.Person;

@Component
public class ConditionRun implements CommandLineRunner {

	@Autowired(required = false)
	private Person person;

	@Override
	public void run(String... args) throws Exception {
		if (person != null) {
			System.out.println("Person: " + person.getName());
		}
	}

}
