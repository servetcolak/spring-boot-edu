package com.training.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CustomerExtra {

	@Id
	@GeneratedValue
	private long id;
	private String tckn;
	private String esAdi;

	@JsonIgnore
	// @XmlTransient
	@OneToOne(fetch = FetchType.LAZY)
	private Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTckn() {
		return tckn;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public String getEsAdi() {
		return esAdi;
	}

	public void setEsAdi(String esAdi) {
		this.esAdi = esAdi;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
