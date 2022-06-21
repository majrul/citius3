package com.gl.demos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.demos.entity.ReadLaterBooks;
import com.gl.demos.exception.BookAlreadyAddedException;
import com.gl.demos.repository.ReadLaterRepository;

/**
 * 
 * @author Shalini
 * Service class that communicates with the database layer and provides
 * implementation for all get and insert operations for Read later section. 
 * Code throws proper exceptions wherever required
 */
@Service
public class ReadLaterService {
	
	// RReadLaterSectionServiceead service has a dependency on the ReadLaterRepository
	@Autowired
	private ReadLaterRepository readLaterRepository;
	
	/* 
	 * @param email the email id of the user to retrieve all the books added by the user in read later section
	 * * @return the list of all the available read later books
	 */
	public List<ReadLaterBooks> getAllBooks(String email)
	{
		return this.readLaterRepository.findByUserEmail(email);
	}
	
	/**
	 * 
	 * @param book the book to be added in read later section
	 * @return true if book was successfully inserted else throws exception
	 * @throws BookAlreadyAddedException 
	 */
	public boolean addReadLaterBook(ReadLaterBooks readlaterbook) throws BookAlreadyAddedException
	{
		Optional<ReadLaterBooks> readlateroptional = this.readLaterRepository
				.findByBookBookidAndUserEmail(readlaterbook.getBook().getBookid(), readlaterbook.getUser().getEmail());
		if(readlateroptional.isPresent())
			throw new BookAlreadyAddedException();
		this.readLaterRepository.save(readlaterbook);
		return true;
	}

}
