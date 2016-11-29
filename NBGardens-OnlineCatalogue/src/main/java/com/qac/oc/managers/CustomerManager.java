package com.qac.oc.managers;

import com.qac.oc.entities.Customer;

/**
 * The entity manager for the customer entity
 * 
 * @author James Thompson
 *
 */
public interface CustomerManager {
	/**
	 * Used to find a customer by their email address.
	 * 
	 * @param email
	 * @return the customer who had that email address.
	 */
	Customer findByEmail(String email);
	
	/**
	 * Used to add a new customer to the database.
	 * 
	 * @param customer 
	 * @return returns the customer object with their newly generated ID.
	 */
	Customer createNewCustomer(Customer customer);
}