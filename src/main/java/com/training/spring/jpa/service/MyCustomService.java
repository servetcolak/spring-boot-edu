package com.training.spring.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.jpa.Customer;
import com.training.spring.jpa.repo.MyCustomRepo;

@Service
public class MyCustomService {

	@Autowired
	MyCustomRepo myCustomRepo;

	public void yaz(Customer customer) {
		myCustomRepo.yaz(customer);
	}

	public void yaz2(Customer customer) {
		myCustomRepo.yaz2(customer);
	}
}
