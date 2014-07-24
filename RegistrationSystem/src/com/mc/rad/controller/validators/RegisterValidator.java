package com.mc.rad.controller.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.mc.rad.model.Customer;

public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object targetObject, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"required.userName", "Field name is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state",
				"required.address", "Field name is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "occupation",
				"required.password", "Field name is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country",
				"required.confirmPassword", "Field name is required.");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", 
				"required.sex", "Field name is required.");
			
			Customer customer = (Customer) targetObject;
			
			
	}

}
