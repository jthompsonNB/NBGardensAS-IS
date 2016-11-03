package com.qac.oc.services;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.sql.Customer;
import com.qac.oc.managers.CustomerManager;

@Stateless
public class LoginService {
	@Inject
	private CustomerManager customerManager;
	
	public boolean validLogin(String email, String password) {
		Customer customer = customerManager.findByEmail(email.toLowerCase());
		if (customer != null)
			return (customer.getPassword().equals(password))? true : false;
		return false;
	}

	public Customer loginUser(String email) {
		return customerManager.findByEmail(email.toLowerCase());
	}
}