package com.passport_visa_management.Models.DAO.Services;

import java.util.List;

import com.passport_visa_management.Models.POJO.Passport;
import com.passport_visa_management.Models.POJO.UsersRegistrations;
import com.passport_visa_management.Models.POJO.Visa;

public interface IVisa {
	public Visa insertVisa(Visa v);
	public List<Visa> fetchVisa();
	public List<Visa> getByUserIdAndStatus(String userId,String status);
	public List<Visa> fetchVisa(String userId);
	
	
	public List<Visa> getvisa(String passportId);
	public Visa updatevisa(Visa V,String visaid);
	public Visa getById(String visaid);
	public UsersRegistrations getUser(String userId);
	public Visa getByPassportId(String passportId);
	public Passport getPassport(String userId);
	
	public List<Visa> getAll();
	public String updateVisaStatus(String visaId);
	public Boolean getNumberOfVisas(String userId,String status);
	
	public void updateVisas(String passportId);
}
