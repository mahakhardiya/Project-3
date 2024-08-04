package com.passport_visa_management.Models.POJO;



public class UpdatePwdUsers {

	
	private String newPassword;

	private String confirmPassword;

	public UpdatePwdUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdatePwdUsers(String newPassword,
			String confirmPassword) {
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
