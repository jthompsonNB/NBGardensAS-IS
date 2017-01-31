package qagardens.common.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import qagardens.common.annotations.Email;

public class EmailValidator implements ConstraintValidator<Email, String>{

	@Override
	public void initialize(Email constraintAnnotation) {
		// TODO Auto-generated method stub		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*" + "@(?:[a-z0-9](?:[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?") && value.length()>7)
			return true;
		return false;
	}
}