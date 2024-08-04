package com.passport_visa_management.Models.DAO.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.passport_visa_management.Models.POJO.Cost;

public interface CostRepository extends JpaRepository<Cost,Integer> {
	public Cost findByOccupationAndMonths(String occupation,int months);
}
