package com.qac.oc.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qac.oc.controllers.session.CurrentUser;
import com.qac.oc.services.LoginService;

@RequestScoped
@Named(value="login")
public class LoginController {
	@Inject
	private CurrentUser currentUser;
	@Inject
	private LoginService loginService;
	private String email = "";
	private String password = "";
	
	public String login() {
		if(!email.isEmpty() && !password.isEmpty())
			if(loginService.validLogin(email, password))
				currentUser.setCustomer(loginService.loginUser(email));
			else
				password = "";
		return "nbgardens";
	}
	
	public String logout() {
		currentUser.setCustomer(null);
		return "nbgardens";
	}
	
	public String getEmail() { return email; }
	public String getPassword() { return password; }
	public void setEmail(String email) { this.email = email; }
	public void setPassword(String password) { this.password = password; }
}