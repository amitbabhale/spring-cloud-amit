package com.example.demo.domain;

import javax.persistence.Id;

import lombok.Data;

@Data
public class Customer {
	@Id
	public String id;

	public String firstName;
	public String lastName;

}
