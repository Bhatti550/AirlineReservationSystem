package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.AirPlaneDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.AirPlane;
import com.ars.airlinereservationsystem.repository.AirPlaneRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirplaneService {

    private final AirPlaneRepository airPlaneRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AirplaneService(AirPlaneRepository airPlaneRepository, ModelMapper modelMapper) {
        this.airPlaneRepository = airPlaneRepository;
        this.modelMapper = modelMapper;
    }

    public AirPlaneDTO addAirplane(AirPlaneDTO airPlaneDTO) {
        AirPlane airPlane = airPlaneRepository.findByAirPlaneNo(airPlaneDTO.getAirPlaneNo());
        if (airPlane != null) {
            throw new CustomServiceException(403, "Data already exist");
        }
        AirPlane airPlane1 = this.modelMapper.map(airPlaneDTO, AirPlane.class);
        airPlaneRepository.save(airPlane1);
        AirPlaneDTO airPlaneDTO1 = this.modelMapper.map(airPlane1, AirPlaneDTO.class);
        return airPlaneDTO1;
    }

    public AirPlaneDTO updateAirplane(AirPlaneDTO airPlaneDTO) {
        AirPlane airPlane = airPlaneRepository.findByAirPlaneNo(airPlaneDTO.getAirPlaneNo());
        if (airPlane != null) {
            throw new CustomServiceException(403, "Data already exist");
        }
        airPlane = this.modelMapper.map(airPlaneDTO, AirPlane.class);
        airPlane.setId(airPlane.getId());
        airPlane.setAirPlaneNo(airPlaneDTO.getAirPlaneNo());
        airPlane.setAirlineCompany(airPlaneDTO.getAirlineCompany());
        airPlaneRepository.save(airPlane);
        AirPlaneDTO airPlaneDTO1 = this.modelMapper.map(airPlane, AirPlaneDTO.class);
        return airPlaneDTO1;
    }
    public AirPlaneDTO getAirPlane(String airPlaneNo){
        AirPlane airPlane=airPlaneRepository.findByAirPlaneNo(airPlaneNo);
        if(airPlane==null){
            throw  new CustomServiceException(404,"Data not exist and can't  update");
        }
        AirPlaneDTO airPlaneDTO=this.modelMapper.map(airPlane,AirPlaneDTO.class);
        return airPlaneDTO;
    }
    public AirPlaneDTO deleteAirplane(String airPlaneNo){
        AirPlane airPlane=airPlaneRepository.findByAirPlaneNo(airPlaneNo);
        if(airPlane!=null){
            AirPlaneDTO airPlaneDTO=this.modelMapper.map(airPlane,AirPlaneDTO.class);
            return airPlaneDTO;
        }else {
            throw new CustomServiceException(404,"Data not found");
        }
    }
    public List<AirPlaneDTO> getAllAirPlanes() {
        List<AirPlane> airPlaneList = airPlaneRepository.findAll();
        if (airPlaneList.isEmpty()) {
            throw new CustomServiceException(404, "Data not found");
        } else {
            List<AirPlaneDTO> airPlaneDTOList = airPlaneList.stream().
                    map(airPlane -> modelMapper.map(airPlaneList, AirPlaneDTO.class))
                    .toList();
            return airPlaneDTOList;
        }
    }
}
