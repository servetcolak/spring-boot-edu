package com.training.spring.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.training.spring.jpa.Adres;

@Component
@Endpoint(id = "testactuator")
public class MyEndpoint {

	@ReadOperation
	public Adres getAdres() {
		Adres adres = new Adres();
		adres.setCity("Adana");
		adres.setStreet("Bizim");
		adres.setTown("Koy");
		return adres;
	}

}
