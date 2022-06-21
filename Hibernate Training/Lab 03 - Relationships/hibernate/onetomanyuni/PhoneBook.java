package hibernate.onetomanyuni;

import java.util.Set;

public class PhoneBook {

	private int id;
	private String name;
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
