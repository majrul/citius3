package com.citiustech.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citiustech.dto.CustomerInfo;
import com.citiustech.dto.RegisterStatus;
import com.citiustech.entity.Customer;
import com.citiustech.exception.CustomerServiceException;
import com.citiustech.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(description = "Set of endpoints for registering and fetching customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//@PostMapping(path = "/register", consumes = "application/json", produces = "application/json")
	@PostMapping(path = "/register", consumes = "application/json", produces = "application/xml")
	@ApiOperation("API for registering a new customer")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Customer already exists in case"),
		@ApiResponse(code = 200, message = "Status with the confirmation and other details")
	})
	public RegisterStatus register(@ApiParam("Data required for adding a Customer") 
								   @RequestBody Customer customer) {
		int id = customerService.register(customer);
		//return "Customer Registered Successfully!";	
		RegisterStatus status = new RegisterStatus();
		status.setStatus(true);
		status.setMessageIfAny("Registration Done!");
		status.setRegisteredCustomerId(id);
		return status;
	}
	
	/*@PostMapping("/register")
	public ResponseEntity<RegisterStatus> register(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			//return "Customer Registered Successfully!";	
			RegisterStatus status = new RegisterStatus();
			status.setStatus(true);
			status.setMessageIfAny("Registration Done!");
			status.setRegisteredCustomerId(id);
			return new ResponseEntity<>(status, HttpStatus.OK);
		}
		catch(CustomerServiceException e) {
			RegisterStatus status = new RegisterStatus();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
		}
	}*/
	
	@GetMapping("/all-customers")
	//@GetMapping(path="/all-customers", produces = {"application/xml", "application/json"})
	public List<Customer> getAll() {
		return customerService.fetchAll();
	}
	
	//@GetMapping("/single-customer")
	@GetMapping(path = "/single-customer", produces = {"application/xml", "application/json"})
	public CustomerInfo get(@RequestParam("id") int id) {
		//return customerService.fetch(id);
		Customer customer = customerService.fetch(id);
		//TODO: Any API to do this copy/paste automatically?
		CustomerInfo customerInfo = new CustomerInfo();
		
		BeanUtils.copyProperties(customer, customerInfo);
		BeanUtils.copyProperties(customer.getAddress(), customerInfo);
		/*CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setId(customer.getId());
		customerInfo.setName(customer.getName());
		customerInfo.setEmail(customer.getEmail());
		customerInfo.setDateOfBirth(customer.getDateOfBirth());
		customerInfo.setCity(customer.getAddress().getCity());
		customerInfo.setState(customer.getAddress().getState());
		customerInfo.setPincode(customer.getAddress().getPincode());*/
		return customerInfo;
	}
}
