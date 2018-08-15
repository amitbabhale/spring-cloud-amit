package com.eq.tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.eq.tdd.model.Cart;
import com.eq.tdd.model.Product;
import com.eq.tdd.repo.ProductRepository;
import com.eq.tdd.service.ShoppingCartClient;
/**
 * This is a junit test class created. 
 * Step 1: Add products to the shopping cart.
 * From step1 comment Add is action means we need a method for it.
 * product is repository in which i should search for item , available quantity, price etc.
 * shopping cart is consumer of product so i need a client for it.
 * lets start creating classes with no code so created ProductRepository and ShoppingCartClient
 * write a test for step 1.
 * @author amit
 *
 */
public class ShoppingCartTest {
	
	private ProductRepository productRepository;
	private ShoppingCartClient shoppingCartClient;

	/**
	 * Mocks are created there is no infrastructure created to store data.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		productRepository = Mockito.mock(ProductRepository.class);
		shoppingCartClient = Mockito.mock(ShoppingCartClient.class);
	}

	/**
	 * write a test code for 
	 * given:	empty shopping cart
	 * 			a product, Dove Soap with a unit price of 39.99
	 * 
	 * When	: 
	 * 			user adds 5 Dove Soaps to the shopping cart
	 * 
	 * Then	:
	 * 			shopping cart should contain 5 Dove Soaps each with a unit price of 39.99
	 * 			shopping cart’s total price should equal 199.95
	 */
	@Test
	public void positive_shouldGetProductInCart() {
		
		//Declare empty shopping cart. 
		Cart cart = null;
		
		//compiler shows error as Cart class does not exist so create a Cart class in Model package
		
		//To create a product dove i wrote a builder pattern
		Product dove = Product.builder.name("Dove").price(39.99).build;
		
		//compiler gives error as Product class does not exist so created a product class. 
		//now builder is showing error so i need to add dependency on lombok and add annotation on product class.
		
		
	}

}
