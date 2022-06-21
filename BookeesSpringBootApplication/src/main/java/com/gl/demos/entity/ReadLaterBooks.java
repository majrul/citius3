package com.gl.demos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Shalini
 *	ReadLaterBooks class that represents read later books structure as a database managed entity to save 
 *  the books added by a particular user in the read later section
 *  @Entity that tells spring JPA to map this class ReadLaterBooks with database table readlater
 */

@Entity
@Table(name="readlater")
public class ReadLaterBooks {
	
	// Id that tells spring JPA to map it as a primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name="bookid")
	private Book book;
	@OneToOne
	@JoinColumn(name="useremail")
	private Users user;
	
	public ReadLaterBooks() {
		// TODO Auto-generated constructor stub
	} int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ReadLaterBooks [id=" + id + ", bookid=" + book.getBookid() + ", useremail=" + user.getEmail() + "]";
	}
	
	

}
