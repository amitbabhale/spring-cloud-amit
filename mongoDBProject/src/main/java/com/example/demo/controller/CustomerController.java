package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Customer;

@RestController
public class CustomerController {

	private Customer customer;
	
	public ResponseEntity<Customer> publishCustomer(){
		return new ResponseEntity<>(HttpStatus.CREATED);	
	}
	
}
