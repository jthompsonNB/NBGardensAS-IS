package com.qac.oc.managers.offline;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qac.oc.entities.Customer;
import com.qac.oc.managers.CustomerManager;
import com.qac.oc.util.TestData;

@Stateless
@Default
public class CustomerManagerOffline implements CustomerManager {
	@Inject
	private TestData testData;
	
	@Override
	public Customer findByEmail(String email) {
		for(Customer customer : testData.getCustomers())
			if(customer.getEmail().equalsIgnoreCase(email))
				return customer;
		return null;
	}

	@Override
	public Customer createNewCustomer(Customer customer) {
		List<Customer> customers = testData.getCustomers();
		customer.setId(customers.size()+1);
		customers.add(customer);
		testData.setCustomers(customers);
		return findByEmail(customer.getEmail());
	}
}