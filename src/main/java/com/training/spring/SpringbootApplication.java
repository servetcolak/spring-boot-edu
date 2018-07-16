package com.training.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//Rol bazli yetki vermek istedigimizde kullanilir.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringbootApplication implements ApplicationRunner {

	@Autowired
	private MyObject myObject;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(myObject);
	}

}
