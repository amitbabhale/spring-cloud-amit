/**
 * 
 */
package com.example.demo.service;

import com.example.demo.domain.Customer;

/**
 * @author amit
 *
 */
public interface CustomerService {
	
	public Customer createCustomer(Customer customer);
	
	public Customer deleteCustomer(String sutomerId);

}
