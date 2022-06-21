package com.citiustech;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.citiustech.entity.User;
import com.citiustech.repository.UserRepository;

@SpringBootTest
public class SpringBootDemoApplicationTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	void addUser() {
		User user = new User();
		user.setName("Majrul");
		user.setEmail("majrul@gmail");
		
		userRepository.save(user);
	}

	@Test
	void fetchUsersByEmail() {
		Iterable<User> users = userRepository.findByEmail("gmail");
		for(User user : users)
			System.out.println(user);
	}
}
