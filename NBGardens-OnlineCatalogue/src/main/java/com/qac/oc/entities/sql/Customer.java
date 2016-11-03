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

	public String getPassword() {
		return password;
	}
}