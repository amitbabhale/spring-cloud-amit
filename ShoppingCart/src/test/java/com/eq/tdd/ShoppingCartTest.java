package com.eq.tdd;

import java.util.Collections;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
	Map<String, Product> cart;
	/**
	 * Mocks are created there is no infrastructure created to store data.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		cart = Collections.EMPTY_MAP;
		//as empty Cart is created. Product class need to be created to fix compile time error.
		
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
		
		//Declare empty shopping cart. it has to be done in junit setup. 

		//To create a product dove use builder patten and i chose lombok library.
		//now builder is showing error so i need to add dependency on lombok and add annotation on product class.
		Product product = Product.builder().name("Dove").price(39.99).build();
		
		Mockito.when(addQuantityToProduct(5,product)).thenReturn(product);
		
		Product dove = addQuantityToProduct(5, product);
		cart.put(dove.getName(), dove);
		
		Assert.assertEquals(5, product.getQuantity());
		
		Mockito.when(calculatePrice()).thenCallRealMethod();
		
		Assert.assertEquals(199.95, calculatePrice());
		
	}

	private double calculatePrice() {
		double cost = 0;
		for (int i = 0 ; i < cart.size() ; i++) {
			Product p = cart.get(i);
			cost = cost + (p.getPrice() * p.getQuantity());	
		}
		
		return Math.round(cost/100);
	}

	private Product addQuantityToProduct(int i, Product product) {		
		return product.builder().quantity(i).build();
	}

}
