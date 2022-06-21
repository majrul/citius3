package com.example.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/all")
	public Iterable<Customer> getall() {
		return customerService.registeredCustomers();
	}
	

	@GetMapping("/id/{id}")
	public Customer get(@PathVariable("id") int id) {
		return customerService.customer(id);
	}
	
}
