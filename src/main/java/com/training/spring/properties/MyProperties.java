package com.training.spring.properties;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.training.spring.model.Person;

//@Validated
@ConfigurationProperties(prefix = "servet")
public class MyProperties {

	private String deneme;

	// @Size(min=10)
	private String test;

	private int port;

	private Person person;

	private String[] strs;

	private List<String> strList;

	public List<String> getStrList() {
		return strList;
	}

	public void setStrList(List<String> strList) {
		this.strList = strList;
	}

	private Map<String, Integer> portMap;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String[] getStrs() {
		return strs;
	}

	public void setStrs(String[] strs) {
		this.strs = strs;
	}

	public Map<String, Integer> getPortMap() {
		return portMap;
	}

	public void setPortMap(Map<String, Integer> portMap) {
		this.portMap = portMap;
	}

	public String getDeneme() {
		return deneme;
	}

	public void setDeneme(String deneme) {
		this.deneme = deneme;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

}
