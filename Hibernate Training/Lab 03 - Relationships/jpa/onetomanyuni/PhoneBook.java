package jpa.onetomanyuni;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="phonebook_jpa")
public class PhoneBook {

	@Id @GeneratedValue
	private int id;
	
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Entry> entries;

	public PhoneBook() {
	}

	public Set<Entry> getEntries() {
		return entries;
	}

	public void setEntries(Set<Entry> entries) {
		this.entries = entries;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PhoneBook [id=" + id + ", name=" + name + "]";
	}
}
