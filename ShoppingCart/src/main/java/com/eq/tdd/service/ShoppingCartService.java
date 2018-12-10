/**
 * 
 */
package com.eq.tdd.service;

import com.eq.tdd.service.model.Item;
import com.eq.tdd.service.model.Iternary;

/**
 * @author amit
 *
 */
public interface ShoppingCartService {

	Iternary getIternary();

	void addProductToCart(Item item);
	
	double calculateTax();
	
	double calculateCost();
	
	double calculateCostWithTax();
	
	double calculateCount();
}
