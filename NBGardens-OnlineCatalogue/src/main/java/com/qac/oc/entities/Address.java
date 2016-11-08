package com.qac.oc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="addresses")
public class Address {
	@Id
	@Column(name="addressId", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="line1", nullable=false, length=225)
	@Size(max=225)
	@NotNull
	private String addressLine1;
	@Column(name="line2", length=225)
	@Size(max=225)
	private String addressLine2;
	@Column(nullable=false, length=225)
	@Size(max=225)
	@NotNull
	private String town;
	@Column(nullable=false, length=6)
	@Size(max=6)
	@NotNull
	private String postcode;

	public Address(){}
	
	public Address(String addressLine1, String town, String postcode) {
		this.addressLine1 = addressLine1;
		this.town = town;
		this.postcode = postcode;
	}

	public Address(String addressLine1, String addressLine2, String town, String postcode) {
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.town = town;
		this.postcode = postcode;
	}
	
	public Address(long id, String addressLine1, String town, String postcode) {
		this.id = id;
		this.addressLine1 = addressLine1;
		this.town = town;
		this.postcode = postcode;
	}

	public Address(long id, String addressLine1, String addressLine2, String town, String postcode) {
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.town = town;
		this.postcode = postcode;
	}
	
	public long getId() { return id; }
	public String getAddressLine1() { return addressLine1; }
	public String getAddressLine2() { return addressLine2; }
	public String getTown() { return town; }
	public String getPostcode() { return postcode; }

	public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }
	public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }
	public void setTown(String town) { this.town = town; }
	public void setPostcode(String postcode) { this.postcode = postcode; }
}