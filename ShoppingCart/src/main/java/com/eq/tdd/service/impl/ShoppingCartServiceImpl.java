package com.eq.tdd.service.impl;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import com.eq.tdd.service.ShoppingCartService;
import com.eq.tdd.service.model.Item;
import com.eq.tdd.service.model.Iternary;

public class ShoppingCartServiceImpl implements ShoppingCartService {

	private List<Item> cart;

	public ShoppingCartServiceImpl (List<Item> cart) {
		this.cart = cart;
	}

	@Override
	public void addProductToCart(Item item) {
		cart.add(item);
	}

	@Override
	public Iternary getIternary() {
		return Iternary.builder().items(cart).build();
	}

	
	private double CalculateRoundValue(double cost) {
		DecimalFormat df = new DecimalFormat(".##");
		String str = df.format(cost);
		int decider = Integer.parseInt(str.substring(str.length()-1, str.length()));
		if(decider >  5) {
			df.setRoundingMode(RoundingMode.UP);
		}
		else{
			df.setRoundingMode(RoundingMode.DOWN);
		}
		return Double.parseDouble(df.format(cost));
	}

	@Override
	public double calculateTax() {		
		return CalculateRoundValue(calculateCost()  * 12.5/100);
	}

	@Override
	public double calculateCost() {
		double cost = 0.0;
		for(Item i: cart){
			cost += i.getQuantity() * i.getProduct().getPrice();
		}		
		return  CalculateRoundValue(cost);
	}

	@Override
	public double calculateCount() {
		int count = 0;
		for (Item i : cart) {
			count = count  + i.getQuantity(); 
		}
		return count;
	}

	@Override
	public double calculateCostWithTax() {
		double totalcost = calculateTax() + calculateCost();
		return CalculateRoundValue(totalcost);
	}


}
