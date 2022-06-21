package com.citiustech.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Everyone!";
	}
	
	//http://localhost:8080/hello2?name=Majrul
	@GetMapping("/hello2")
	public String hello2(@RequestParam("name") String name) {
		return "Hello " + name.toUpperCase();
	}

	//http://localhost:8080/hello3;name=Majrul
	@GetMapping("/hello3")
	public String hello3(@MatrixVariable("name") String name) {
		return "Hello " + name.toUpperCase();
	}

	//http://localhost:8080/hello4/Majrul
	@GetMapping("/hello4/{name}")
	public String hello4(@PathVariable("name") String name) {
		return "Hello " + name.toUpperCase();
	}
}
