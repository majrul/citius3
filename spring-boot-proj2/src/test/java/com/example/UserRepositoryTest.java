package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.entity.User;
import com.example.repository.UserRepository;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void addUser() {
		for(int i=1; i<=20; i++) {
			User user = new User();
			user.setName("Majrul" + i);
			user.setEmail("majrul@gmail" + i);
			
			userRepository.save(user);
		}
	}

	@Test
	void fetchUsersByEmail() {
		Iterable<User> users = userRepository.findByEmail("gmail");
		for(User user : users)
			System.out.println(user);
	}

	@Test
	void fetchUsersByEmailWithPagination() {
		long count = userRepository.count();
		int pageSize = 5;
		long pages = count / pageSize;
		
		for(int i=0; i<pages; i++) {
			Iterable<User> users = userRepository.findByEmailOf("gmail", 
									PageRequest.of(i, pageSize, Sort.by("name").ascending()));
			for(User user : users)
				System.out.println(user);
			
		}
	}

}
