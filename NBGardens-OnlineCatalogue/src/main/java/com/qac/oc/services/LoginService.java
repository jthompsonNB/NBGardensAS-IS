package com.qac.oc.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.Customer;
import com.qac.oc.managers.CustomerManager;

/**
 * This is used to carry out the business logic surrounding Logging in.
 * 
 * @author James Thompson
 *
 */
@Stateless
public class LoginService {
	@Inject
	private CustomerManager customerManager;
	
	/**
	 * Checks to ensure that the provided credentials are valid.
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public boolean validLogin(String email, String password) {
		Customer customer = customerManager.findByEmail(email.toLowerCase());
		return (customer.getPassword().equals(password))? true : false;
	}

	/**
	 * used to retrieve the customer from the entity manager
	 * 
	 * @param email
	 * @return
	 */
	public Customer loginUser(String email) {
		return customerManager.findByEmail(email.toLowerCase());
	}
}