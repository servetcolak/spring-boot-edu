package com.training.spring.jpa.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import com.training.spring.jpa.Customer;

@EnableAsync
public interface ICustomerRepo extends CrudRepository<Customer, Long> {

	List<Customer> findBySurnameAndAgeOrderByName(String surname, int age);

	@Async
	List<Customer> findBySurnameIn(List<String> names);

	@Query(value = "select c from Customer c where c.name=:pName")
	List<Customer> findCustomTest(@Param("pName") String name);

	@Query(value = "select * from customer where name = :pName", nativeQuery = true)
	List<Customer> findCustomNativeTest(@Param("pName") String name);

	List<Customer> findGetCustsByName(String pName);

	List<Customer> GetCustsByNameNative(String pName);

	@Query(value = "select c from Customer c JOIN FETCH c.ced JOIN FETCH c.accounts where c.name=:pName")
	List<Customer> findCustomTestEagerly(@Param("pName") String name);
}
