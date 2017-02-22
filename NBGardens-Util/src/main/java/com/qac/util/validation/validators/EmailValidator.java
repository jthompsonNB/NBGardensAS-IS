package com.qac.util.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.qac.util.validation.Email;

public class EmailValidator implements ConstraintValidator<Email, String>{

	@Override
	public void initialize(Email constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*" + "@(?:[a-z0-9](?:[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?") && value.length()>7)
			return true;
		return false;
	}
}