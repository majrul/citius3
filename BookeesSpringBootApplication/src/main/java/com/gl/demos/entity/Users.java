package com.gl.demos.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author Shalini
 *	Users class that represents users structure as a database managed entity to save 
 *  the users registered
 */
// @Entity that tells spring JPA to map this class Users with database table users
@Entity
public class Users {

	// Id that represents a primary key
	@Id
	private String email;
	private String password;
	private String username;
	private String city;
	private String country;
	private String role ;
	
public Users() {
	// TODO Auto-generated constructor stub
}
	public Users(String email, String password, String username, String city, String country, String role) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.city = city;
		this.country = country;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Users [email=" + email + ", password=" + password + ", username=" + username + ", city=" + city
				+ ", country=" + country + "]";
	}
	
	
}
