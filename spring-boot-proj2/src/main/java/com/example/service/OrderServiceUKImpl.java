package com.example.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("uk")
public class OrderServiceUKImpl implements OrderService {

	@Override
	public void placeOrder() {
		System.out.println("placeOrder for UK customers..");
	}	
}
