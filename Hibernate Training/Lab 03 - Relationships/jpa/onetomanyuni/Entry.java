package jpa.onetomanyuni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entry_jpa")
public class Entry {

	@Id @GeneratedValue
	private int id;
	
	private String name;
	private int number;
	private String email;	
	
	public Entry() {
	}

	public Entry(String name, int number, String email) {
		this.name = name;
		this.number = number;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", name=" + name + ", number=" + number
				+ ", email=" + email + "]";
	}
}
