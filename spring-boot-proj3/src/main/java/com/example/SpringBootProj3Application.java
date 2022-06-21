package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootProj3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProj3Application.class, args);
	}

}

@Component
class MyRunner implements ApplicationRunner {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Product p = new Product();
		p.setName("Nokia 5510");
		p.setPrice(6000);
		p.setQuantity(99);
		productRepository.save(p);
	}
	
}

interface ProductRepository extends CrudRepository<Product, Integer> {
	
}
@Entity
@Table(name = "tbl_prod")
class Product {
	
	@Id @GeneratedValue
	int id;
	String name;
	double price;
	int quantity;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}