package com.gl.demos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.demos.entity.LikedBooks;
import com.gl.demos.entity.ReadLaterBooks;
import com.gl.demos.exception.BookAlreadyAddedException;
import com.gl.demos.repository.LikedBooksRepository;
import com.gl.demos.repository.ReadLaterRepository;

/**
 * 
 * @author Shalini
 * Service class that communicates with the database layer and provides
 * implementation for all get and insert operations for Liked Books section. 
 * Code throws proper exceptions wherever required
 */
@Service
public class LikedBooksService {
	
	// RReadLaterSectionServiceead service has a dependency on the ReadLaterRepository
	@Autowired
	private LikedBooksRepository likedBooksRepository;
	
	/* 
	 * @param email the email id of the user to retrieve all the books added by the user in read later section
	 * * @return the list of all the available read later books
	 */
	public List<LikedBooks> getAllBooks(String email)
	{
		return this.likedBooksRepository.findByUserEmail(email);
	}
	
	/**
	 * 
	 * @param book the book to be added in read later section
	 * @return true if book was successfully inserted else throws exception
	 * @throws BookAlreadyAddedException 
	 */
	public boolean addReadLaterBook(LikedBooks likedBooks) throws BookAlreadyAddedException
	{
		Optional<LikedBooks> readlateroptional = this.likedBooksRepository.findByBookBookidAndUserEmail(likedBooks.getBook().getBookid(),
				likedBooks.getUser().getEmail());
		if(readlateroptional.isPresent())
			throw new BookAlreadyAddedException();
		this.likedBooksRepository.save(likedBooks);
		return true;
	}

}
