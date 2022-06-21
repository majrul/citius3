package com.gl.demos.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.demos.entity.Book;
import com.gl.demos.entity.Users;

/**
 * 
 * @author Shalini
 * 
 * By extending CrudRepository, UsersRepository inherits several methods for working with Users persistence, 
 * including methods for saving, deleting, and finding Users entities.
 *
 */
public interface UsersRepository extends CrudRepository<Users, String>{

}
