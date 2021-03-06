/**
 * 
 */
package com.eq.tdd.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author amit
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
	private String id;
	private String name;
	private double price;
}
