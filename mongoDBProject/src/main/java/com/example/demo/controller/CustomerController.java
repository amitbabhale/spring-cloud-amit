package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;

@RestController
public class CustomerController {

	private Customer customer;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> publishCustomer(@RequestBody Customer customer){
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}
	
}
