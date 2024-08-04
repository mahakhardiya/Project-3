package com.passport_visa_management.Models.DAO.Services;


import org.springframework.data.jpa.repository.JpaRepository;

import com.passport_visa_management.Models.POJO.StateDetails;

public interface StateRepository extends JpaRepository<StateDetails, Integer>{
	StateDetails findByStateName(String stateName);
}
