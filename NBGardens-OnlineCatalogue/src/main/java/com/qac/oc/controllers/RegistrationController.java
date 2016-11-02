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
	private String firstName;
	private String lastName;
	private String email;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String postcode;
	
	public String register() {
		if(!firstName.isEmpty() && !lastName.isEmpty() && !addressLine1.isEmpty() && !town.isEmpty() && !postcode.isEmpty() && !email.isEmpty())
			try {
				if(addressLine2.isEmpty())
					currentUser.setCustomer(registrationService.register(firstName, lastName, email, addressLine1, town, postcode));
				else
					currentUser.setCustomer(registrationService.register(firstName, lastName, email, addressLine1, addressLine2, town, postcode));
				return "nbgardens";
			} catch (RegistrationError re) {
				System.out.println(re.getMessage());
			}
		return "register";
	}
}