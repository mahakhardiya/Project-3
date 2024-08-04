package com.techwave.Models.BAO;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy =DOBValidator.class )
@Target( { ElementType.METHOD, ElementType.FIELD,ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface dobValidate {

	String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
