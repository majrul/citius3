package com.gl.demos.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.demos.entity.Book;
import com.gl.demos.repository.BookRepository;

/**
 * 
 * @author Shalini
 * Service class that communicates with the database layer and provides
 * implementation for all the crud operations for books. 
 * Code throws proper exceptions wherever required
 */
@Service
public class BookService {
	
	// Book service has a dependency on the BookRepository
	@Autowired
	private BookRepository bookRepository;
	
	/**
	 * 
	 * @return the list of all the available books
	 */
	public List<Book> getAllBooks()
	{
		List<Book> books = new ArrayList<>();
		this.bookRepository.findAll().forEach(book->books.add(book));
		return books;
	}
	/**
	 * 
	 * @param bookid the id of the book to fetch the book details
	 * @return the book retrieved if found by id or else throws exception
	 */
	public Book getBookById(int bookid)
	{
		return this.bookRepository
				.findById(bookid)
				.orElseThrow(()-> new EntityNotFoundException("Book with id "+bookid+" does not exist"));
	}
	/**
	 * 
	 * @param bookid the id of the existing book to update
	 * @return true of book was found and updated successfully else throws an exception
	 */
	
	public boolean updateBook(Book book)
	{
		if(!this.bookRepository.existsById(book.getBookid()))
			throw new EntityNotFoundException("Book with id "+book.getBookid()+" does not exist and cannot be updated");	
		else {
			this.bookRepository.save(book);
			return true;
		}
	}
	/**
	 * 
	 * @param bookid the id of the book to delete
	 * @return true if book is deleted successfully, else throws an exception
	 */
	public boolean deleteBookById(int bookid)
	{

		if(!this.bookRepository.existsById(bookid))
			throw new EntityNotFoundException("Book with id "+bookid+" does not exist and cannot be deleted");	
		else {
			this.bookRepository.deleteById(bookid);
			return true;
		}
	}
	/**
	 * 
	 * @param book the book to be added
	 * @return true if book was successfully inserted else throws an exception
	 */
	public boolean addBook(Book book)
	{
		if(this.bookRepository.existsById(book.getBookid()))
			throw new EntityNotFoundException("Book with id "+book.getBookid()+" already exists and cannot be added");	
		else {
			this.bookRepository.save(book);
			return true;
		}
	}

}
