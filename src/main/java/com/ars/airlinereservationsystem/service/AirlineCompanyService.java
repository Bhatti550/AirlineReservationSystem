package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.AirlineCompanyDTO;
import com.ars.airlinereservationsystem.dto.UserDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.AirlineCompany;
import com.ars.airlinereservationsystem.repository.AirlineCompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class AirlineCompanyService {
    private final AirlineCompanyRepository airlineCompanyRepository;
    private final ModelMapper modelMapper;
    @Autowired
    AirlineCompanyService(AirlineCompanyRepository airlineCompanyRepository,ModelMapper modelMapper){
        this.airlineCompanyRepository=airlineCompanyRepository;
        this.modelMapper=modelMapper;
    }
    public AirlineCompanyDTO addAirlineCompany(AirlineCompanyDTO airlineCompanyDTO){
        AirlineCompany airlineCompany=airlineCompanyRepository.findByName(airlineCompanyDTO.getName());
        if(airlineCompany!=null){
            throw new CustomServiceException(404,"Company already exist with same name");
        } else if (airlineCompany.getName().isEmpty()||airlineCompany.getEmail().isEmpty()) {
            throw new CustomServiceException(400,"Some Data is Missing");
        }
        else {
           AirlineCompany airlineCompany1=this.modelMapper.map(airlineCompanyDTO, AirlineCompany.class);
            airlineCompanyRepository.save(airlineCompany1);
            AirlineCompanyDTO airlineCompanyDTO1=this.modelMapper.map(airlineCompany1, AirlineCompanyDTO.class);
        }
        return airlineCompanyDTO;
    }
    public AirlineCompanyDTO updateAirlineCompany(AirlineCompanyDTO airlineCompanyDTO){
        AirlineCompany airlineCompany=airlineCompanyRepository.findByName(airlineCompanyDTO.getName());
        if(airlineCompany!=null){
            airlineCompany.setId(airlineCompany.getId());
            airlineCompany.setEmail(airlineCompanyDTO.getEmail());
            airlineCompany.setName(airlineCompanyDTO.getName());
           airlineCompany.setNumber(airlineCompanyDTO.getContactNumber());
           airlineCompany.setLocation(airlineCompanyDTO.getLocation());
           airlineCompanyRepository.save(airlineCompany);
            return this.modelMapper.map(airlineCompany, AirlineCompanyDTO.class);
        }
        else {
            throw new CustomServiceException(404,"User Data Not found");
        }
    }
    public AirlineCompanyDTO getAirlineCompany(String name){
        AirlineCompany airlineCompany=airlineCompanyRepository.findByName(name);
        if (airlineCompany!=null)
        {
            AirlineCompanyDTO airlineCompanyDTO=this.modelMapper.map(airlineCompany,AirlineCompanyDTO.class);
            return airlineCompanyDTO;
        }
        else {
            throw  new CustomServiceException(404,"Data not found");
        }
    }
    public AirlineCompanyDTO deleteAirlineCompany(String name){
        AirlineCompany airlineCompany=airlineCompanyRepository.findByName(name);
        if(airlineCompany!=null)
        {
            airlineCompanyRepository.delete(airlineCompany);
        }
        else {
            throw new CustomServiceException(404,"Data not found");
        }
        return this.modelMapper.map(airlineCompany,AirlineCompanyDTO.class);
    }
    public List<AirlineCompanyDTO> getAllAirlineCompany(){
        List<AirlineCompany> airlineCompanyList=airlineCompanyRepository.findAll();
        List<AirlineCompanyDTO> airlineCompanyDTOList=airlineCompanyList.stream().
                map(airlineCompany -> modelMapper.map(airlineCompanyList, AirlineCompanyDTO.class))
                .toList();
        return airlineCompanyDTOList;
    }
}
