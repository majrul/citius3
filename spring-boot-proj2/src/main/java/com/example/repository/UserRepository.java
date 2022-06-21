package com.example.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.entity.User;

//public interface UserRepository extends CrudRepository<User, Integer> {
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email like %?1%")
	public Iterable<User> findByEmail(String email);
	
	@Query("select u from User u where u.email like %?1%")
	public Page<User> findByEmailOf(String domain, Pageable pageable);
}
