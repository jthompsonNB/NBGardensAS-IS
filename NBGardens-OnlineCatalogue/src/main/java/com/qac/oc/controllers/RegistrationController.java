package com.qac.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.controllers.session.CurrentUser;
import com.qac.oc.services.RegistrationService;
import com.qac.oc.util.RegistrationError;

@Named("register")
@RequestScoped
public class RegistrationController {
	@Inject
	private RegistrationService registrationService;
	@Inject
	private CurrentUser currentUser;
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String password = "";
	private String addressLine1 = "";
	private String addressLine2 = "";
	private String town = "";
	private String postcode = "";
	
	public String register() {
		if(!firstName.isEmpty() && !lastName.isEmpty() && !addressLine1.isEmpty() && !town.isEmpty() && !postcode.isEmpty() && !email.isEmpty() && !password.isEmpty())
			try {
				if(addressLine2.isEmpty())
					currentUser.setCustomer(registrationService.register(firstName, lastName, email, password, addressLine1, town, postcode));
				else
					currentUser.setCustomer(registrationService.register(firstName, lastName, email, password, addressLine1, addressLine2, town, postcode));
				return "nbgardens";
			} catch (RegistrationError re) {
				System.out.println(re.getMessage());
			}
		return "register";
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public String getAddressLine1() { return addressLine1; }
	public String getAddressLine2() { return addressLine2; }
	public String getTown() { return town; }
	public String getPostcode() { return postcode; }
	
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }
	public void setAddressLine1(String addressLine1) { this.addressLine1 = addressLine1; }
	public void setAddressLine2(String addressLine2) { this.addressLine2 = addressLine2; }
	public void setTown(String town) { this.town = town; }
	public void setPostcode(String postcode) { this.postcode = postcode; }
}