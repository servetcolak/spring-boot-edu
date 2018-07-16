package com.training.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.test.ConfSecond;
import com.test.MyImpl3;
import com.training.spring.IMyInt;
import com.training.spring.MyImpl;
import com.training.spring.TestComponent;
import com.training.spring.properties.MyProperties;

@Configuration
@PropertySource("classpath:my.properties")
@EnableConfigurationProperties
@Import(ConfSecond.class)
@ImportResource("classpath:beantest.xml")
public class MyConfiguration {
	
	private ApplicationContext context;
	
	@Autowired
	public MyConfiguration(ApplicationContext context) {
		this.context = context;
	}
	
	@Bean
	public IMyInt createMyInt() {
		MyImpl myImpl = new MyImpl();
		return myImpl;
	}
	
	@Bean
	@Qualifier("veli")
	public IMyInt createMyInt3(@Value("#{sampleComp.method1()}") String str) {
		MyImpl3 myImpl = new MyImpl3();
		myImpl.setStr(str);
		return myImpl;
	}

	@Bean
	public TestComponent testComp() {
		TestComponent comp = new TestComponent();
		comp.setTestStr("TestComponent");
		return comp;
	}
	
	@Bean
	public MyProperties createMyProperties() {
		return new MyProperties();
	}
	
	@Autowired
	public void testMyProperties(MyProperties properties) {
		System.out.println(properties.toString());
	}
	
	
	@Autowired
	public void testOneTimeCall(@Value("${servet.deneme}")String para) {
		System.out.println("Test: " + para);
	}
	
	@Autowired
	public void testOneTimeCall2() {
		String para = context.getEnvironment().getProperty("servet.deneme");
		System.out.println("Test: " + para);
	}
	
	@Autowired
	public void testOneTimeCall2(Environment environment) {
		String para = environment.getProperty("servet.deneme");
		System.out.println("Test: " + para);
	}
	
}
