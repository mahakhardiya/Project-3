package com.passport_visa_management.Models.DAO.Services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.passport_visa_management.Models.POJO.Passport;


@Repository
public interface PassportRepository extends JpaRepository<Passport, String>{
	public Passport findByPassportId(String userId);
	Passport findByUserIdUserId(String userIdString);
	Passport findByUserIdUserIdAndStatus(String userId,String status);
}
