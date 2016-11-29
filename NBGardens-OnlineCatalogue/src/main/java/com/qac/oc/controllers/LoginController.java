package com.qac.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.controllers.session.CurrentUser;
import com.qac.oc.services.LoginService;

/**
 * This controller is used for logging in and out users from the website.
 * 
 * @author James Thompson
 */
@RequestScoped
@Named(value="login")
public class LoginController {
	@Inject
	private CurrentUser currentUser;
	@Inject
	private LoginService loginService;
	private String email = "";
	private String password = "";
	
	/**
	 * Attempts to log users into the application, sending the user to the home page on completion 
	 * 
	 * @return
	 */
	public String login() {
		if(!email.isEmpty() && !password.isEmpty())
			if(loginService.validLogin(email, password))
				currentUser.setCustomer(loginService.loginUser(email));
			else
				password = "";
		return "nbgardens";
	}
	
	/**
	 * loggs out the user and then sends them to the home page
	 * 
	 * @return returns nbgardens
	 */
	public String logout() {
		currentUser.setCustomer(null);
		return "nbgardens";
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}