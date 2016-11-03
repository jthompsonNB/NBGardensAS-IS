package com.qac.oc.services;

import java.time.LocalDate;
import java.time.ZoneId;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qac.oc.entities.sql.Address;
import com.qac.oc.entities.sql.Customer;
import com.qac.oc.managers.CustomerManager;
import com.qac.oc.messenging.CustomerConverter;
import com.qac.oc.messenging.NotifyIMS;
import com.qac.oc.util.RegistrationError;

@Stateless
public class RegistrationService {
	@Inject
	private CustomerManager customerManager;
	@Inject
	private NotifyIMS notifyIMS;
	@Inject
	private CustomerConverter customerConverter;
	
	public Customer register(String firstName, String lastName, String email, String password, String addressLine1, String town, String postcode) throws RegistrationError {
		if(customerManager.findByEmail(email)  != null)
			throw new RegistrationError();
		Customer customer = customerManager.createNewCustomer(new Customer(firstName, lastName, email, password, new Address(addressLine1, town, postcode), getCurrentDate()));
		notifyIMS.newCustomerForCatalogue(customerConverter.convert(customer));
		return customer;
	}

	public Customer register(String firstName, String lastName, String email, String password, String addressLine1, String addressLine2, String town, String postcode) throws RegistrationError {
		if(customerManager.findByEmail(email)  != null)
			throw new RegistrationError();
		Customer customer = customerManager.createNewCustomer(new Customer(firstName, lastName, email, password, new Address(addressLine1, addressLine2, town, postcode), getCurrentDate()));
		notifyIMS.newCustomerForCatalogue(customerConverter.convert(customer));
		return customer;
	}
	
	private LocalDate getCurrentDate() {
		return LocalDate.now(ZoneId.of("Europe/London"));
	}
}