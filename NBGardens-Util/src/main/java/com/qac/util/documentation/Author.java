package com.qac.util.documentation;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

/**
 * Used to specify the author of fields, methods and constructors
 * 
 * @author James Thompson
 */
@Target({CONSTRUCTOR, METHOD, FIELD})
@Documented
public @interface Author {
	String value();
}