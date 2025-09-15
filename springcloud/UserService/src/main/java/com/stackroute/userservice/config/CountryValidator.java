package com.stackroute.userservice.config;

import java.util.Arrays;
import java.util.List;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryValidator implements ConstraintValidator<Country,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		List<String> countrylist=Arrays.asList("india","japan","uk");
		
		
		return countrylist.contains(value.toLowerCase());
	}

}
