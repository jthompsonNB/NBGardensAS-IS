package com.qac.oc.entities.sql;

public class Address {
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String postcode;

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

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getTown() {
		return town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}