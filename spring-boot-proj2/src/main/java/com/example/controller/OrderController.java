package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/place-order")
	public void placeOrder() {
		orderService.placeOrder();
	}
	
}
