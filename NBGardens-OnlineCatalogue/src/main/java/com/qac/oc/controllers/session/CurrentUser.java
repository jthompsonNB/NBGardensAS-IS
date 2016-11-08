package com.qac.oc.controllers.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.qac.oc.entities.Customer;

@Named("user")
@SessionScoped
public class CurrentUser implements Serializable{
	private Customer customer = null;

	public boolean isLoggedIn() {
		return (customer==null) ? false : true;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}