package com.training.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.training.spring.IMyInt;
import com.training.spring.MyObject;
import com.training.spring.model.Person;

//@Controller // rendering calisir, mvc gibi davranir.
@RestController
@RequestScope
public class MyRest {

	@Autowired
	private MyObject myObject;

	@Autowired
	@Qualifier("mehmet")
	private IMyInt mi;

	@Autowired
	@Qualifier("createMyInt")
	private IMyInt mi1;

	@Autowired
	@Qualifier("veli")
	private IMyInt mi3;

	// primitive tiplerde text doner, objelerde ise json formatinda doner.
	@RequestMapping("/hello")
	public MyObject helloWorld(Authentication auth) {
		User user = (User) auth.getPrincipal();
		for (GrantedAuthority authors : user.getAuthorities()) {
			System.out.println("ROLE: " + authors.getAuthority());
		}
		if (user.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"))) {
			System.out.println("ADMIN");
			myObject.setText("Hello ADMIN");
		} else {
			myObject.setText("Hello USER");
		}

		return myObject;
	}
	
	// TODO: Aspect ile yapilabilir.
	// Rollere gore yetki verilmesi bu sekilde yapilabilir.
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/secure")
	public String secureMethod() {
		return "Hello ADMIN";
	}

	@RequestMapping(path = "/m")
	public String method1() {
		return mi.execute();
	}

	@RequestMapping(path = "/m", method = RequestMethod.POST)
	public String method2() {
		return mi.execute() + "POST";
	}

	@RequestMapping(path = "/m", method = RequestMethod.PUT)
	public String method3() {
		return mi1.execute() + " create bean!";
	}

	@RequestMapping(path = "/m3/{abc}/hello/{xyz}")
	public String method4(@RequestParam("name") String str, @RequestParam("age") int age,
			@PathVariable("abc") String dep, @PathVariable("xyz") String xyz, @RequestHeader("user") String user) {
		String val = "name: " + str + ", age: " + age + ", dep: " + dep + ", xyz: " + xyz + ", User: " + user;
		System.out.println(val);
		return val;
	}

	@RequestMapping(path = "/m5", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public String method5(@RequestBody Person person) {
		System.out.println(person.getName());
		return person.getName();
	}

	@RequestMapping(path = "/m6", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public Person method6(@RequestBody Person person) {
		System.out.println(person.getName());
		person = new Person();
		person.setAge(16);
		person.setName("Ali");
		person.setSurname("Veli");
		return person;
	}

	@RequestMapping(path = "/m7", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Person method7(Person person) {
		System.out.println(person.getName());
		// person = new Person();
		// person.setAge(17);
		// person.setName("Ali1");
		// person.setSurname("Veli2");
		return person;
	}

}
