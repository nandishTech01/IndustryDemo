package com.IndustrialDemo.Annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.Validator;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = empValidator.class)
public @interface ValidateFirstName{
	
	public String message() default "firstname was invalid";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
