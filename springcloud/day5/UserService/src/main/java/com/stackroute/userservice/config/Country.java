package com.stackroute.userservice.config;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target ({FIELD})
@Retention (RUNTIME)
@Constraint(validatedBy=CountryValidator.class)


public @interface Country {
	
	String message() default "Country is not valid";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	

}
