package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.caching.Customer;
import com.example.caching.CustomerRepository;
import com.zaxxer.hikari.HikariDataSource;

@SpringBootApplication
@EnableCaching
public class SpringBootProj4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProj4Application.class, args);
	}

}

@Component
@RestControllerEndpoint(enableByDefault = true, id = "ds")
class MyDataSourceActuatorEndpoint {
	
	@Autowired
	HikariDataSource dataSource;
	
	@RequestMapping("/ds-info")
	public DsInfo someInfo() {
		DsInfo info = new DsInfo();
		info.currentPoolSize = dataSource.getMinimumIdle();
		return info;
	}
}

class DsInfo {
	int currentPoolSize;
	
	public int getCurrentPoolSize() {
		return currentPoolSize;
	}
	public void setCurrentPoolSize(int currentPoolSize) {
		this.currentPoolSize = currentPoolSize;
	}
}

//@Component
class Initializer implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Customer c1 = new Customer();
		c1.setFirstName("James");
		c1.setLastName("Gosling");
		c1.setEmail("james@gmail.com");
		
		Customer c2 = new Customer();
		c2.setFirstName("Bill");
		c2.setLastName("Gates");
		c2.setEmail("bill@gmail.com");

		Customer c3 = new Customer();
		c3.setFirstName("Steve");
		c3.setLastName("Jobs");
		c3.setEmail("steve@gmail.com");
		
		customerRepository.save(c1);
		customerRepository.save(c2);
		customerRepository.save(c3);

	}
}