package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany,Long> {
}
