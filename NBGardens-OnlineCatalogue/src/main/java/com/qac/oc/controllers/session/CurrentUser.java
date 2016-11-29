package com.qac.oc.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.qac.oc.entities.Customer;

/**
 * This holds the customer information for the customer the session is associated with. 
 * 
 * @author James Thompson
 *
 */
@Named("user")
@SessionScoped
public class CurrentUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4453234212177318400L;
	private Customer customer = null;

	/**
	 * used to check if there is a user logged in
	 * 
	 * @return true if the user is logged in
	 */
	public boolean isLoggedIn() {
		return (customer==null) ? false : true;
	}
	
	public Customer getCustomer() { return customer; }

	public void setCustomer(Customer customer) { this.customer = customer; }
}