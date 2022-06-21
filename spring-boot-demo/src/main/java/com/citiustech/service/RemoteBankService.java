package com.citiustech.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.citiustech.entity.Trade;

@Service
//@ConfigurationProperties(prefix = "bank-api")
public class RemoteBankService {

	@Value("${bank-api.url}")
	private String url;
	
	//TODO: Use Environment object to read any property
	//@Autowired
	//private Environment env;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void communicate(Trade trade) {
		//TODO: Can we inject RestTemplate so that we don't have to create the object
		RestTemplate rt = new RestTemplate();
		String responseFromBank = rt.postForObject(url, trade, String.class);
		//based on the response some logic will be here

	}
}
