package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example1 {

	@RequestMapping("/example1")
	public String example1() {
		return "Example 1";
	}
}
