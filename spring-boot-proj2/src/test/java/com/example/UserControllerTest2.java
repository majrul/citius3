package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.example.controller.UserController;
import com.example.entity.User;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerTest2 {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port; 
	
	@Test
	public void test() {
		String url = "http://localhost:" + port + "/user/{id}";
		User user = restTemplate.getForObject(url, User.class, 1);
		System.out.println(user);
		assertNotNull(user);
	}
}
