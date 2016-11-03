package com.qac.util.messages;

import java.io.Serializable;

import com.qac.util.enums.CustomerStatus;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3676550804198348165L;
	private long id;
	private String firstName;
	private String lastname;
	private String email;
	private CustomerStatus status;
	private Address address;

	public Customer(String firstName, String lastname, String email, Address address) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		status = CustomerStatus.SIGNED_UP;
	}

	public long getId() { return id; }
	public String getFirstName() { return firstName; }
	public String getLastname() { return lastname; }
	public String getEmail() { return email; }
	public Address getAddress() { return address; }
	public CustomerStatus getStatus() { return status; }

	public void setStatus(CustomerStatus status) { this.status = status; }
	public void setId(long id) { this.id = id; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastname(String lastname) { this.lastname = lastname; }
	public void setEmail(String email) { this.email = email; }
	public void setAddress(Address address) { this.address = address; }
}