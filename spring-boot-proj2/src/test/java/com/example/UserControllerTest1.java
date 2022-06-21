package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.controller.UserController;
import com.example.entity.User;

@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class UserControllerTest1 {

	@Autowired
	private UserController userController;
	
	@Test
	public void test() {
		User user = userController.get(1);
		assertNotNull(user);
	}
}
