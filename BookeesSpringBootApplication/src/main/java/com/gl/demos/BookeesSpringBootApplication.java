package com.gl.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.demos.entity.Book;
import com.gl.demos.entity.Users;
import com.gl.demos.service.BookService;
import com.gl.demos.service.UsersService;

//https://mkyong.com/spring-boot/spring-rest-spring-security-example/
@SpringBootApplication
public class BookeesSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookeesSpringBootApplication.class, args);
	}

	@Autowired
	private BookService bookService;
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Bean
	public void initialize()
	{
		Book b1 = new Book("Core Java","Cay hortsmann",234.45,"In detailed understanding of java");
		Book b2= new Book("HTML","Kathy Sierra",464.45,"In detailed understanding of HTML5");
		Book b3 = new Book("PHP","Balaguruswamy",178.87,"Learn to create web application");
		
		Users users1 = new Users("abc@email.com", encoder.encode("abc123"), "ABC", "Mumbai","India", "ROLE_USER");
		Users users2 = new Users("pqr@email.com", encoder.encode("pqr123"), "PQR", "Delhi","India", "ROLE_USER");
		Users users3 = new Users("admin@email.com", encoder.encode("admin"), "ABADMINC", "Pune","India", "ROLE_ADMIN");
		
		bookService.addBook(b1);
		bookService.addBook(b2);
		bookService.addBook(b3);
		
		usersService.addUsers(users1);
		usersService.addUsers(users2);
		usersService.addUsers(users3);
		
	}
}
