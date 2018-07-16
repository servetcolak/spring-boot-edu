package com.training.spring.jpa.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.jpa.Customer;

@Repository
@Transactional
public class MyCustomRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Transactional(propagation = Propagation.NEVER)
	public void yaz(Customer customer) {
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		try {
			// entityManager2.joinTransaction();

			entityManager2.getTransaction().begin();
			entityManager2.persist(customer);
			entityManager2.getTransaction().commit();
		} catch (Exception e) {
			entityManager2.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Transactional(rollbackFor = IllegalArgumentException.class, noRollbackFor = IllegalAccessException.class, propagation = Propagation.REQUIRED)
	public void yaz2(Customer customer) {
		// if (customer.getAge() < 18) {
		// throw new IllegalArgumentException();
		// }
		entityManager.persist(customer);
	}

	public List<Customer> fillAll(List<Customer> customers) {
		List<Customer> mergedCustomers = new ArrayList<Customer>();
		for (Customer customer : customers) {
			Customer mergedCustomer = entityManager.merge(customer);
			mergedCustomer.getAccounts();
			mergedCustomer.getCed();
			mergedCustomers.add(mergedCustomer);
		}

		return mergedCustomers;
	}

}
