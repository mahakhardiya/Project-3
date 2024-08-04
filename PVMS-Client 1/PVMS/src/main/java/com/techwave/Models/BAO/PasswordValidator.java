package com.techwave.Models.BAO;


import com.techwave.Models.Pojos.UpdatePwdUsers;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordValidate, UpdatePwdUsers> {

	@Override
	public boolean isValid(UpdatePwdUsers value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if (value.getNewPassword() != null || value.getConfirmPassword() != null) {
			
			if (value.getNewPassword().equals(value.getConfirmPassword()))
				return true;
			else
				return false;
		}
		return true;
	}

}
