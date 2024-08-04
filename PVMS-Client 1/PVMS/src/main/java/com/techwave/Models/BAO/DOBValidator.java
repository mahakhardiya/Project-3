package com.techwave.Models.BAO;

import java.time.LocalDate;

import com.techwave.Models.Pojos.UsersRegistrations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DOBValidator implements ConstraintValidator<dobValidate, UsersRegistrations> {

	@Override
	public boolean isValid(UsersRegistrations value, ConstraintValidatorContext context) {
		if(value.getDateOfBirth()!=null)
		{
		if(value.getDateOfBirth().compareTo(LocalDate.now())>=0)
			return false;
		else
			return true;
		}
		return true;
		}

}
