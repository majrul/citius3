package com.gl.demos.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gl.demos.entity.Book;
import com.gl.demos.entity.ReadLaterBooks;

/**
 * 
 * @author Shalini
 * 
 * By extending CrudRepository, ReadLaterRepository inherits several methods for working with ReadLater persistence, 
 * including methods for saving, deleting, and finding ReadLater entities.
 *
 */
public interface ReadLaterRepository extends CrudRepository<ReadLaterBooks, Integer>{

	public ArrayList<ReadLaterBooks> findByUserEmail(String email);
	public Optional<ReadLaterBooks> findByBookBookidAndUserEmail(int bookid, String email);
}
