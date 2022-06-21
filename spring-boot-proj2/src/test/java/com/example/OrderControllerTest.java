package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.controller.OrderController;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class OrderControllerTest {

	@Autowired
	private OrderController orderController;
		
	@Test
	public void test() {
		orderController.placeOrder();
	}

}
