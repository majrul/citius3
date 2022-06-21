package com.citiustech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.entity.Trade;
import com.citiustech.service.RemoteBankService;
import com.citiustech.service.TradeService;

//Server A
@RestController
public class TradeController {

	@Autowired
	private TradeService tradeService;
	
	@Autowired
	private RemoteBankService remoteBankService;
	
	@PostMapping("/newTrade")
	public String postNewTrade(@RequestBody Trade trade) {
		tradeService.process(trade);
		remoteBankService.communicate(trade);
		
		return "Trade record created successfully!";
	}

}
