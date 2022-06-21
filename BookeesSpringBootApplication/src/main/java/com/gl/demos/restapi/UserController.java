package com.gl.demos.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.demos.entity.Book;
import com.gl.demos.service.LikedBooksService;
import com.gl.demos.service.ReadLaterService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private ReadLaterService readLaterService;
	
	@Autowired
	private LikedBooksService likedBooksService;

	@GetMapping("/readlater")
	public List<Book> getAllBooks( @PathVariable String email)
	{
		System.out.println("get all read later books");
		this.readLaterService.getAllBooks(email);
		return null;
	}

}
