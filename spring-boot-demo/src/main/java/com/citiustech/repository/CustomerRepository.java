package com.citiustech.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.citiustech.entity.Customer;

@Repository
public class CustomerRepository extends GenericRepository {

	public List<Customer> findAll() {
		return entityManager
				.createQuery("select c from Customer c", Customer.class)
				.getResultList();
	}

	public boolean isCustomerPresent(String email) {
		return (Long) 
				entityManager
				.createQuery("select count(c) from Customer c where c.email = :em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}
}
