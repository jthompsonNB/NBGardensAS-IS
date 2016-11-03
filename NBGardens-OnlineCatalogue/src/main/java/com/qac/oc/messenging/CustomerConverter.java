package com.qac.oc.messenging;

import javax.ejb.Stateless;

import com.qac.util.messages.Address;
import com.qac.util.messages.Customer;

@Stateless
public class CustomerConverter {
		
	public Customer convert(com.qac.oc.entities.sql.Customer customer) {
		Address address;
		if (customer.getAddress().getAddressLine2()==null)
			address = new Address(customer.getAddress().getAddressLine1(), customer.getAddress().getTown(), customer.getAddress().getPostcode());
		else 
			address = new Address(customer.getAddress().getAddressLine1(), customer.getAddress().getAddressLine2(), customer.getAddress().getTown(), customer.getAddress().getPostcode());
		return new Customer(customer.getFirstName(), customer.getLastname(), customer.getEmail(), address);
	}
}