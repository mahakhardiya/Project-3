package com.techwave.Models.Pojos;

import com.techwave.Models.BAO.PasswordValidate;

import jakarta.validation.constraints.NotBlank;

@PasswordValidate(message = "Confirm password should be same as New password")
public class UpdatePwdUsers {

	@NotBlank(message = "*Required")
	private String newPassword;
	@NotBlank(message = "*Required")
	private String confirmPassword;

	public UpdatePwdUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdatePwdUsers(@NotBlank(message = "*Required") String newPassword,
			@NotBlank(message = "*Required") String confirmPassword) {
		super();
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
