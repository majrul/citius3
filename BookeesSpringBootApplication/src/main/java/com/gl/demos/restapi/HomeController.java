package com.gl.demos.restapi;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.demos.entity.Book;
import com.gl.demos.entity.LoginUser;
import com.gl.demos.entity.Messages;
import com.gl.demos.entity.ResponsePage;
import com.gl.demos.service.BookService;
import com.gl.demos.service.MyUserDetailsService;

@RestController
@CrossOrigin
public class HomeController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@GetMapping("/")
	public String getPrincipal(Principal p)
	{
		System.out.println(SecurityContextHolder.getContext().getAuthentication());
		if(p!=null)
		return p.getName();
		return "Prinicpal not found";
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginUser user) {
		System.out.println("authenticate ......");
		System.out.println(user);
		try {
			Authentication auth = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(auth);
			System.out.println("***");
//			UserDetails principal = userDetailsService.loadUserByUsername(user.getEmail());
//			Authentication authentication = new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities());
//			SecurityContext context = SecurityContextHolder.createEmptyContext();
//			context.setAuthentication(authentication);
//			System.out.println(SecurityContextHolder.getContext().getAuthentication());
			//SecurityContextHolder.getContext().setAuthentication(null)
		}
		catch(BadCredentialsException e)
		{
			//throw new Exception();
			System.out.println("login failed");
			return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE,"login failed please contact admin"));
		}
		catch(Exception e)
		{
			System.out.println(e);
			return ResponseEntity.badRequest().body(new ResponsePage(Messages.FAILURE,"Invalid credentials"));
		}
		return ResponseEntity.ok().body(new ResponsePage(Messages.SUCCESS,"login success"));
	}
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return this.bookService.getAllBooks();
	}
}
