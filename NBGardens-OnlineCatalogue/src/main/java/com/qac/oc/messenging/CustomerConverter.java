package com.qac.oc.messenging;

import javax.ejb.Stateless;

import com.qac.util.messages.Address;
import com.qac.util.messages.Customer;

/**
 * Used to handle the conversion of one customer object into another
 * 
 * @author James Thompson
 *
 */
@Stateless
public class CustomerConverter {
		
	/**
	 * Converts a Customer Entity into a Customer message.
	 * 
	 * @param customer
	 * @return
	 */
	public Customer convert(com.qac.oc.entities.Customer customer) {
		Address address;
		if (customer.getAddress().getAddressLine2()==null)
			address = new Address(customer.getAddress().getAddressLine1(), customer.getAddress().getTown(), customer.getAddress().getPostcode());
		else 
			address = new Address(customer.getAddress().getAddressLine1(), customer.getAddress().getAddressLine2(), customer.getAddress().getTown(), customer.getAddress().getPostcode());
		return new Customer(customer.getFirstName(), customer.getLastName(), customer.getEmail(), address);
	}
}