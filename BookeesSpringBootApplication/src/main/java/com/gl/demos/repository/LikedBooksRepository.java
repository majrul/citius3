package com.gl.demos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gl.demos.entity.LikedBooks;

/**
 * 
 * @author Shalini
 * 
 * By extending CrudRepository, LikedBooksRepository inherits several methods for working with LikedBooks persistence, 
 * including methods for saving, deleting, and finding LikedBooks entities.
 *
 */
public interface LikedBooksRepository extends CrudRepository<LikedBooks, Integer>{
	
	public ArrayList<LikedBooks> findByUserEmail(String email);
	public Optional<LikedBooks> findByBookBookidAndUserEmail(int bookid, String email);
}
