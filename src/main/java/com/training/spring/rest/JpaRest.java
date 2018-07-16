package com.training.spring.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.enm.ETestEnum;
import com.training.spring.jpa.Account;
import com.training.spring.jpa.Adres;
import com.training.spring.jpa.Customer;
import com.training.spring.jpa.CustomerExtra;
import com.training.spring.jpa.EMyEnum;
import com.training.spring.jpa.MyExtra;
import com.training.spring.jpa.repo.MyCustomRepo;
import com.training.spring.jpa.springdata.ICustomerRepo;

@RestController
@RequestMapping("/jpa")
public class JpaRest {

	@Autowired
	private MyCustomRepo customRepo;

	@Autowired
	private ICustomerRepo customerRepo;

	@RequestMapping(path = "/yaz", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer yaz(@RequestParam("name") String name) {

		Customer cust = new Customer();
		cust.setName(name);
		cust.setAge(11);
		cust.setSurname("colak2");
		cust.setBirthDate(new Date());
		cust.setMyEnum(EMyEnum.TEST2);
		cust.setOther1("Other3");
		cust.setOther2("Other4");
		cust.setTemp("My Temp");
		cust.setExtra1("Extra1");
		cust.setExtra2("Extra2");

		CustomerExtra customerExtra = new CustomerExtra();
		customerExtra.setCustomer(cust);
		customerExtra.setEsAdi("Es Adi");
		customerExtra.setTckn("123456789");
		cust.setCed(customerExtra);

		MyExtra extra = new MyExtra();
		extra.setAbc("Abc");
		extra.setXyz("xyz");
		cust.setMyExtra(extra);
		System.out.println(ETestEnum.STATE1.getRealName());
		System.out.println(ETestEnum.STATE2.getRealName());

		List<Account> acList = new ArrayList<Account>();

		Account account = new Account();
		account.setAmount(12);
		account.setCustomer(cust);
		account.setName("Account1");
		acList.add(account);

		account = new Account();
		account.setAmount(12);
		account.setCustomer(cust);
		account.setName("Account2");
		acList.add(account);

		cust.setAccounts(acList);

		Adres adres = new Adres();
		adres.setCity("Adana");
		adres.setStreet("Bizim");
		adres.setTown("Aladağ");
		cust.setAdres(adres);

		customRepo.yaz(cust);

		return cust;
	}

	@RequestMapping(path = "/yaz2", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer yaz2(@RequestParam("name") String name) {

		Customer cust = new Customer();
		cust.setName(name);
		cust.setAge(11);
		cust.setSurname("colak3");
		cust.setBirthDate(new Date());
		cust.setMyEnum(EMyEnum.TEST2);
		cust.setOther1("Other3");
		cust.setOther2("Other4");
		cust.setTemp("My Temp");
		cust.setExtra1("Extra1");
		cust.setExtra2("Extra2");

		CustomerExtra customerExtra = new CustomerExtra();
		customerExtra.setCustomer(cust);
		customerExtra.setEsAdi("Es Adi");
		customerExtra.setTckn("123456789");
		cust.setCed(customerExtra);

		MyExtra extra = new MyExtra();
		extra.setAbc("Abc");
		extra.setXyz("xyz");
		cust.setMyExtra(extra);
		System.out.println(ETestEnum.STATE1.getRealName());
		System.out.println(ETestEnum.STATE2.getRealName());

		List<Account> acList = new ArrayList<Account>();

		Account account = new Account();
		account.setAmount(12);
		account.setCustomer(cust);
		account.setName("Account1");
		acList.add(account);

		account = new Account();
		account.setAmount(12);
		account.setCustomer(cust);
		account.setName("Account2");
		acList.add(account);

		cust.setAccounts(acList);

		customRepo.yaz(cust);

		return cust;
	}

	@RequestMapping(path = "/yaz3", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Customer yaz3(@RequestParam("name") String name) {

		Customer cust = new Customer();
		cust.setName(name);
		cust.setAge(11);
		cust.setSurname("colak3");
		cust.setBirthDate(new Date());
		cust.setMyEnum(EMyEnum.TEST2);
		cust.setOther1("Other3");
		cust.setOther2("Other4");
		cust.setTemp("My Temp");
		cust.setExtra1("Extra1");
		cust.setExtra2("Extra2");

		CustomerExtra customerExtra = new CustomerExtra();
		customerExtra.setCustomer(cust);
		customerExtra.setEsAdi("Es Adi");
		customerExtra.setTckn("123456789");
		cust.setCed(customerExtra);

		MyExtra extra = new MyExtra();
		extra.setAbc("Abc");
		extra.setXyz("xyz");
		cust.setMyExtra(extra);
		System.out.println(ETestEnum.STATE1.getRealName());
		System.out.println(ETestEnum.STATE2.getRealName());

		List<Account> acList = new ArrayList<Account>();

		Account account = new Account();
		account.setAmount(12);
		account.setCustomer(cust);
		account.setName("Account1");
		acList.add(account);

		account = new Account();
		account.setAmount(12);
		account.setCustomer(cust);
		account.setName("Account2");
		acList.add(account);

		cust.setAccounts(acList);

		customerRepo.save(cust);

		return cust;
	}

	@RequestMapping("/native")
	public List<Customer> findCustomNativeTest(@RequestParam("name") String name) {
		List<Customer> list = customerRepo.findCustomNativeTest(name);
		return list;
	}

	@RequestMapping("/namedquery")
	public List<Customer> findGetCustsByName(@RequestParam("name") String name) {
		List<Customer> list = customerRepo.findGetCustsByName(name);
		list = customRepo.fillAll(list);
		return list;
	}

	@RequestMapping("/customTest")
	public List<Customer> findCustomTest(@RequestParam("name") String name) {
		List<Customer> list = customerRepo.findCustomTest(name);
		return list;
	}

	@RequestMapping("/namednativequery")
	public List<Customer> findGetCustsByNameNative(@RequestParam("name") String name) {
		List<Customer> list = customerRepo.GetCustsByNameNative(name);
		return list;
	}

	@RequestMapping("/eagerly")
	public List<Customer> findCustomTestEagerly(@RequestParam("name") String name) {
		List<Customer> list = customerRepo.findCustomTestEagerly(name);
		return list;
	}

}
