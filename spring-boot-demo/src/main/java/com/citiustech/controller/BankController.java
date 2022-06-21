package com.citiustech.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entity.Trade;

//Server B
@RestController
public class BankController {

	@PostMapping("/newTradePayment")
	public String postNewTrade(@RequestBody Trade trade) {
		//flow missing right now
		return "Payment processed by Bank for the Trade!";
	}
	
}
