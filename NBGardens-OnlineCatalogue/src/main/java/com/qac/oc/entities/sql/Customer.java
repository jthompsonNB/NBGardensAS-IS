package com.qac.oc.entities.sql;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer implements Serializable {
	@Id
	@Column(name="id", nullable=false, unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastname;
	private String email;
	private String password;
	private Address address;
	private LocalDate dateAdded;

	public Customer(String firstName, String lastname, String email, String password, Address address, LocalDate dateAdded) {
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.dateAdded = dateAdded;
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Address getAddress() {
		return address;
	}

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}
}