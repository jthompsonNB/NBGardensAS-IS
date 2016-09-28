package com.qac.oc.controllers;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;

import com.qac.oc.entities.sql.Customer;

@SessionScoped
public class CurrentUser implements Serializable{
	private static final long serialVersionUID = -7329313706265108418L;
	private Customer customer;

	public boolean isLoggedIn() {
		return (customer==null) ? false : true;
	}
	
	Customer getCustomer() {
		return customer;
	}

	void setCustomer(Customer customer) {
		this.customer = customer;
	}
}