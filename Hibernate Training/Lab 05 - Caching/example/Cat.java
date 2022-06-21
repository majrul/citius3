package example;

import java.util.HashSet;
import java.util.Set;

public class Cat {

	private int id;
	private String name;
	private int age;
	private Cat parent;
	private Set kittens;
	
	public Cat() {}
	
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Cat(String name, int age, Cat parent) {
		this.name = name;
		this.age = age;
		this.parent = parent;
	}
	
	public void newKitten(Cat cat) {
		getKittens().add(cat);
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set getKittens() {
		return kittens == null ? new HashSet() : kittens;
	}
	public void setKittens(Set kittens) {
		this.kittens = kittens;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cat getParent() {
		return parent;
	}
	public void setParent(Cat parent) {
		this.parent = parent;
	}
	
	
}
