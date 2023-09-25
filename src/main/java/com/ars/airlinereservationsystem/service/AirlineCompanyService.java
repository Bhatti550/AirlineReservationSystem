package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.AirlineCompanyDTO;
import com.ars.airlinereservationsystem.model.AirlineCompany;
import com.ars.airlinereservationsystem.repository.AirlineCompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AirlineCompanyService {
    private final AirlineCompanyRepository airlineCompanyRepository;
    private final ModelMapper modelMapper;
    @Autowired
    AirlineCompanyService(AirlineCompanyRepository airlineCompanyRepository,ModelMapper modelMapper){
        this.airlineCompanyRepository=airlineCompanyRepository;
        this.modelMapper=modelMapper;
    }
    public AirlineCompanyDTO addAirline(AirlineCompanyDTO airlineCompanyDTO){
        AirlineCompany airlineCompany=
        return airlineCompanyDTO;
    }
}
