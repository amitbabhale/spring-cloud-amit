package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sender.Sender;

@RestController
public class CustomerController {

	@Autowired
	private Sender sender;
	
	@PostMapping("/send")
	public ResponseEntity<String> publishCustomer(@RequestBody String message){
		try {
			System.out.println("Sending message");
			sender.sendMessage(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return new ResponseEntity<String>(HttpStatus.OK);	
	}
	
}
