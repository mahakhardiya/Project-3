package com.passport_visa_management.Models.DAO.Services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.passport_visa_management.Models.POJO.CityDetails;

@Repository
public interface CityRepository extends JpaRepository<CityDetails, Integer> {
    List<CityDetails> findByStateStateId(Integer stateId);
    CityDetails findByCityName(String cityName);
}
