package com.qac.oc.enums;

/**
 * This represents the states a stock line can have.
 * 
 * @author James Thompson
 *
 */
public enum ProductStatus {
	/**
	 * The product is active
	 */
	ACTIVE, 
	/**
	 * Is no longer sold
	 */
	DISCONTINUED, 
	/**
	 * The product is only sold in spring
	 */
	SPRING, 
	/**
	 * The product is only sold in summer
	 */
	SUMMER, 
	/**
	 * The product is only sold in autumn.
	 */
	AUTUMN, 
	/**
	 * The product is only sold in winter.
	 */
	WINTER
}