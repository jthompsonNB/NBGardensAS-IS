package com.qac.oc.managers;

import com.qac.oc.entities.sql.Customer;

public interface CustomerManager {
	Customer findByEmail(String email);
	Customer createNewCustomer(Customer customer);
}