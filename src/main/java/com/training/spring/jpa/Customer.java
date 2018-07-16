package com.training.spring.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@NamedQueries({ @NamedQuery(name = "Customer.GetCustsByName", query = "select c from Customer c where c.name=:pName") })
@NamedNativeQueries({
		@NamedNativeQuery(name = "Customer.GetCustsByNameNative", query = "select * from customer where name = :pName") })
@Entity
@Table(name = "CUSTOMER", indexes = { @Index(columnList = "name", unique = true) })
@SecondaryTable(name = "secondperson")
@SecondaryTables({ @SecondaryTable(name = "secondperson"), @SecondaryTable(name = "thirdperson") })
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private long id;

	@Size(min = 3, max = 20)
	@Column(name = "NAME", length = 20, nullable = false)
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Convert(converter = AdresConverter.class)
	private Adres adres;

	private String personalMidName;

	private int age;

	@Column(table = "secondperson")
	private String extra1;

	@Column(table = "secondperson")
	private String extra2;

	@Column(table = "thirdperson")
	private String other1;

	@Column(table = "thirdperson")
	private String other2;

	@Embedded
	@AttributeOverride(column = @Column(name = "test_abc"), name = "abc")
	private MyExtra myExtra;

	@Enumerated(EnumType.STRING)
	private EMyEnum myEnum;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthDate;

	@Transient
	private String temp;

	// @JsonIgnore
	// @XmlTransient
	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH, CascadeType.REMOVE })
	@JoinColumn(name = "CUSTOMER_EXTRA_ID")
	private CustomerExtra ced;

	// @JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> accounts;

	@PrePersist
	@PreUpdate
	@PreRemove
	public void beforeWrite() {

	}

	@PostPersist
	@PostRemove
	@PostUpdate
	@PostLoad
	public void afterWrite() {

	}

	public Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPersonalMidName() {
		return personalMidName;
	}

	public void setPersonalMidName(String personalMidName) {
		this.personalMidName = personalMidName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getExtra1() {
		return extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	public String getExtra2() {
		return extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

	public String getOther1() {
		return other1;
	}

	public void setOther1(String other1) {
		this.other1 = other1;
	}

	public String getOther2() {
		return other2;
	}

	public void setOther2(String other2) {
		this.other2 = other2;
	}

	public MyExtra getMyExtra() {
		return myExtra;
	}

	public void setMyExtra(MyExtra myExtra) {
		this.myExtra = myExtra;
	}

	public EMyEnum getMyEnum() {
		return myEnum;
	}

	public void setMyEnum(EMyEnum myEnum) {
		this.myEnum = myEnum;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public CustomerExtra getCed() {
		return ced;
	}

	public void setCed(CustomerExtra ced) {
		this.ced = ced;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

}
