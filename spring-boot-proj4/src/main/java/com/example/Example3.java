package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example3 {

	@RequestMapping("/example3")
	public String example3() {
		return "Example 3";
	}
}
