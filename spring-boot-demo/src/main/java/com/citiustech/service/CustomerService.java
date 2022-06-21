package com.citiustech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiustech.entity.Customer;
import com.citiustech.exception.CustomerServiceException;
import com.citiustech.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Transactional
	public int register(Customer customer) {
		if(customerRepository.isCustomerPresent(customer.getEmail()))
			throw new CustomerServiceException("Customer already exists!");
		else {
			Customer updatedCustomer = (Customer) customerRepository.save(customer);
			return updatedCustomer.getId();
		}
	}
	
	public List<Customer> fetchAll() {
		return customerRepository.findAll();
	}
	
	public Customer fetch(int id) {
		return customerRepository.findById(Customer.class, id);
	}
}
