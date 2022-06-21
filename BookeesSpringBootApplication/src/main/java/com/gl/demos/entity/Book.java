package com.gl.demos.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author Shalini
 *	Book class that represents book structure as a database managed entity
 */
// @Entity that tells spring JPA to map this class Book with database table book
@Entity
public class Book {

	// @Id that tells spring JPA to map bookid as a primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookid;
	private String title;
	private String author;
	private double price;
	private String description;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(String title, String author, double price, String description) {
		
		this.title = title;
		this.author = author;
		this.price = price;
		this.description = description;
	}

	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", price=" + price
				+ ", description=" + description + "]";
	}
	
	
}

