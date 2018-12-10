package com.eq.tdd;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.eq.tdd.service.ShoppingCartService;
import com.eq.tdd.service.impl.ShoppingCartServiceImpl;
import com.eq.tdd.service.model.Item;
import com.eq.tdd.service.model.Product;
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
@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest {
	
	private List<Item> cart;
	
//	@Mock
	ShoppingCartService shoppingCartService; 
	/**
	 * Mocks are created there is no infrastructure created to store data.
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {		
		cart = new ArrayList<>(Lists.emptyList());
		shoppingCartService = new ShoppingCartServiceImpl(cart);
		//as empty Cart is created. Product class need to be created to fix compile time error.
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
	@SuppressWarnings("static-access")
	@Test
	public void positive_shouldGetProductInCart() {
		
		Item Item = null;
		//Declare empty shopping cart. it has to be done in junit setup. 
		//To create a product dove use builder patten and i chose lombok library.
		//now builder is showing error so i need to add dependency on lombok and add annotation on product class.
		Product product = Product.builder().id("1").name("Dove").price(39.99).build();
		Item item1 = Item.builder().product(product).quantity(5).build();
		cart.add(item1);
		double actualCost = 199.95;
		double cost = shoppingCartService.calculateCost();
		Assert.assertEquals(actualCost, cost, 0 );
		
	}

	@SuppressWarnings("static-access")
	@Test
	public void positive_shouldGetMultipleProductInCartWithTax() {
		
		//Declare empty shopping cart. it has to be done in junit setup. 
		//To create a product dove use builder patten and i chose lombok library.
		//now builder is showing error so i need to add dependency on lombok and add annotation on product class.
		
		Product product = Product.builder().id("1").name("Dove").price(39.99).build();
		Item item1 = Item.builder().product(product).quantity(2).build();
		
		Product product2 = Product.builder().id("2").name("Axe ").price(99.99).build();
		Item item2 = Item.builder().product(product2).quantity(2).build();
		
		shoppingCartService.addProductToCart(item1);
		shoppingCartService.addProductToCart(item2);
		
		double actualCost = 314.96;
		double actaulCount = 4;
		double actualTax = 35.00;
		
		 
		Assert.assertEquals(actualCost, shoppingCartService.calculateCostWithTax(), 0 );
		Assert.assertEquals(actaulCount, shoppingCartService.calculateCount(), 0 );
		Assert.assertEquals(actualTax, shoppingCartService.calculateTax(), 0 );
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void positive_shouldGetMultipleProductInCart() {
		
		//Declare empty shopping cart. it has to be done in junit setup. 
		//To create a product dove use builder patten and i chose lombok library.
		//now builder is showing error so i need to add dependency on lombok and add annotation on product class.
		
		Product product = Product.builder().id("1").name("Dove").price(39.99).build();
		Item item1 = Item.builder().product(product).quantity(5).build();
		Item item2 = Item.builder().product(product).quantity(3).build();
		cart.add(item1);
		cart.add(item2);
		
		double actualCost = 319.92;
		double actaulCount = 8;		
		
		Assert.assertEquals(actualCost, shoppingCartService.calculateCost(), 0 );
		Assert.assertEquals(actaulCount, shoppingCartService.calculateCount(), 0 );		
		
	}
}
