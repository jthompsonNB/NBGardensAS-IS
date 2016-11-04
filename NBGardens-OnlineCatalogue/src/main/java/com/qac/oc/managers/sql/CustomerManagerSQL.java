package com.qac.oc.managers.sql;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.qac.oc.entities.sql.Customer;
import com.qac.oc.managers.CustomerManager;

@Alternative
@Stateless
public class CustomerManagerSQL implements CustomerManager {
	
	@Override
	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer createNewCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
}