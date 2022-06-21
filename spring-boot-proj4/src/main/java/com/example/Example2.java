package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example2 {

	@RequestMapping("/example2")
	public String example2() {
		return "Example 2";
	}
}
