package com.example;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootProj5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProj5Application.class, args);
	}
}

@RestController
class HelloController {

	@RequestMapping(method = RequestMethod.GET, path = "/hello")
	public Map<String, String> hello(Principal p) {
		return Collections.singletonMap("message", "Hello " + p.getName());
	}

	@RequestMapping("/hello1")
	@RolesAllowed("ROLE_USER")
	public String hello1() {
		return "Hello Users";
	}

	@RequestMapping("/hello2")
	@RolesAllowed("ROLE_ADMIN")
	public String hello2() {
		return "Hello Admins";
	}
}

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccountDetailsService accountDetailsService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override 
	protected UserDetailsService userDetailsService() { 
		return accountDetailsService; 
	}
	 
	/*protected UserDetailsService userDetailsService() {
		UserDetails user1 = User.withUsername("user").password("{noop}password").roles("USER").build();
		UserDetails user2 = User.withUsername("admin").password("{noop}password").roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user1, user2);
	};*/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests(
				authz -> authz.anyRequest().authenticated())
		.httpBasic();
	}
}

//@Component
class CreateAccount implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		Account acc = new Account();
		acc.setActive(true);
		acc.setUsername("majrul");
		acc.setPassword(passwordEncoder.encode("123"));
		accountRepository.save(acc);
	}
}

@Service
class AccountDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return accountRepository.findByUsername(username)
				.map(account -> new User(username, account.getPassword(),
						AuthorityUtils.createAuthorityList("ROLE_USER")))
				.orElseThrow(() -> new UsernameNotFoundException("couldn't find " + username));
	}

}

interface AccountRepository extends JpaRepository<Account, Long> {
	Optional<Account> findByUsername(String username);
}

@Entity
@Table(name = "tbl_acc")
class Account {

	@Id
	@GeneratedValue
	private Long id;

	private String username;
	private String password;
	private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
