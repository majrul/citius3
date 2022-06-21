package com.gl.demos.restapi;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", methods = RequestMethod.GET)
public class AdminController {

	
	@GetMapping()
	public String insertBook()
	{
		System.out.println("add");
		return "inserts";
	}
}
