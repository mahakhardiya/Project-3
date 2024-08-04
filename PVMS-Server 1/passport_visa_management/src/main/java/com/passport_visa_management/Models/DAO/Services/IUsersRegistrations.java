package com.passport_visa_management.Models.DAO.Services;

import java.util.List;

import com.passport_visa_management.Models.POJO.UpdatePwdUsers;
import com.passport_visa_management.Models.POJO.UsersRegistrations;

public interface IUsersRegistrations {
	public UsersRegistrations getUserById(String userId);
	public List<UsersRegistrations> getAllUsers();

	public String addUserDetails(UsersRegistrations URdetails);

	public UsersRegistrations getByEmail(String email);

	public UsersRegistrations getByContactNumber(String number);

	UsersRegistrations updatePassword(String id, UpdatePwdUsers u);
	
}
