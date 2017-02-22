package com.qac.util.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.qac.util.validation.validators.EmailValidator;

@Constraint(validatedBy={EmailValidator.class})
@Retention(RUNTIME)
@Target({FIELD, PARAMETER, ANNOTATION_TYPE})
public @interface Email {
	String message() default "Invalid Email Address";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}