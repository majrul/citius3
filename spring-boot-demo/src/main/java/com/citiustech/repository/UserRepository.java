package com.citiustech.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.citiustech.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("select u from User u where u.email like %?1%")
	public Iterable<User> findByEmail(String email);
}
