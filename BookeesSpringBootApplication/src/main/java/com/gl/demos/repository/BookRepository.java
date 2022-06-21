package com.gl.demos.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.demos.entity.Book;

/**
 * 
 * @author Shalini
 * 
 * By extending CrudRepository, BookRepository inherits several methods for working with Book persistence, 
 * including methods for saving, deleting, and finding Book entities.
 *
 */
public interface BookRepository extends CrudRepository<Book, Integer>{

}
