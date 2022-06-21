package com.gl.demos.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.demos.entity.Users;
import com.gl.demos.repository.UsersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("user details service "+username);
		 Optional<Users> account = this.usersRepository.findById(username);
	        System.out.println(account.get());
	        return account.map(
	                acc -> {
	                   User user =  new User(acc.getEmail(),
	                          acc.getPassword(),
	                            true, true,
	                            true, true,
	                            Arrays.stream(acc.getRole().split(","))
	                                    .map(SimpleGrantedAuthority::new)
	                                    .collect(Collectors.toList()));
	                    System.out.println(user);
	                    return user;
	                }
	        ).orElseThrow(()->new UsernameNotFoundException("Username not found"));
	}

}
