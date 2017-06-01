/**
 * 
 */
package com.example.demo.controller.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.domain.Customer;

/**
 * @author amit
 *
 */
public interface CustomerRepository extends MongoRepository<Customer, String>{

}
