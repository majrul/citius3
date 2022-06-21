package com.example.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("us")
public class OrderServiceUSImpl implements OrderService {

	@Override
	public void placeOrder() {
		System.out.println("placeOrder for US customers..");
	}	
}
