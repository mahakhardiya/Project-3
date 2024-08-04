package com.passport_visa_management.Models.DAO.Services;

import java.util.List;
import com.passport_visa_management.Models.POJO.Passport;
import com.passport_visa_management.Models.POJO.PassportLost;
import com.passport_visa_management.Models.POJO.RenewalOfPassport;

public interface IPassport {
	
	public List<Passport> getAll();
	public Passport getByPassportId(String passportId);
	public String SaveRenewalDetailsToDb(RenewalOfPassport renewalDetails);
	public Passport getByUserId(String userId);
	public String checkExpiryDate(String userId);
	public Integer maxPassport();	
	public Passport getByUserIdAndStatus(String userId,String status);
	public String updatePassportAfterLoss(PassportLost passportLost);
	
	//Tarun
	public String createpassport(Passport user, String userId);
	public String PassportExists(String userId);
	
	
}
