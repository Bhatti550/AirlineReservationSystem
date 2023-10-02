package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.SeatDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Seat;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import com.ars.airlinereservationsystem.repository.SeatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final ModelMapper modelMapper;
    @Autowired
    public SeatService(SeatRepository seatRepository, ModelMapper modelMapper) {
        this.seatRepository = seatRepository;
        this.modelMapper = modelMapper;
    }
    public SeatDTO addSeat(SeatDTO seatDTO){
        Seat seat=seatRepository.findBySeatNo(seatDTO.getSeatNo());
        if (seat!=null){
            seatRepository.save(seat);
            SeatDTO seatDTO1=this.modelMapper.map(seat, SeatDTO.class);
            return seatDTO1;
        }
        else {
            throw new CustomServiceException(403,"Record is already exist");
        }
    }
    public SeatDTO updateSeat(SeatDTO seatDTO){
        Seat seat=seatRepository.findBySeatNo(seatDTO.getSeatNo());
        if (seat!=null){
            seat.setId(seat.getId());
            seat.setSeatNo(seatDTO.getSeatNo());
            seat.setPrice(seatDTO.getPrice());
            seat.setTravelClass(seatDTO.getTravelClass());
            seat.setAirPlane(seatDTO.getAirPlane());
            seat.setAvailableStatus(seatDTO.isAvailableStatus());
            seatRepository.save(seat);
            SeatDTO seatDTO1=this.modelMapper.map(seat, SeatDTO.class);
            return seatDTO1;
        }
        else {
            throw new CustomServiceException(403,"Record is already exist");
        }
    }
    public List<SeatDTO> getAllSeat() {
        List<Seat> seatList = seatRepository.findAll();
        if (seatList.isEmpty()) {
            throw new CustomServiceException(404, "Records not found");
        } else {
            List<SeatDTO> seatDTOList = seatList.stream()
                    .map(seat -> modelMapper.map(seatList, SeatDTO.class))
                    .toList();
            return seatDTOList;
        }
    }
    public SeatDTO deleteSeat(int seatNo){
        Seat seat=seatRepository.findBySeatNo(seatNo);
        if(seat!=null){
            seatRepository.delete(seat);
            SeatDTO seatDTO=this.modelMapper.map(seat, SeatDTO.class);
            return seatDTO;
        }else
        {
            throw new CustomServiceException(404,"Record not found");
        }
    }
    public SeatDTO getSeat(int seatNo){
        Seat seat=seatRepository.findBySeatNo(seatNo);
        if (seat!=null){
            SeatDTO seatDTO=this.modelMapper.map(seat, SeatDTO.class);
            return seatDTO;
        }else {
            throw new CustomServiceException(404,"Records not Found");
        }
    }
    public List<SeatDTO> getSeatByPrice(double startPrice, double endPrice ){
        List<Seat> seatList=seatRepository.findByPriceStartsWithAndPriceEndingWith(startPrice,endPrice);
        if(seatList.isEmpty()){
            throw new CustomServiceException(404,"Data not Found");
        }else {
            List<SeatDTO> seatDTOList = seatList.stream()
                    .map(seat -> modelMapper.map(seatList, SeatDTO.class))
                    .toList();
            return seatDTOList;
        }
    }
    public List<SeatDTO> getSeatByStatus(boolean availableStatus){
        List<Seat> seatList=seatRepository.findByAvailableStatus(availableStatus);
        if(seatList.isEmpty()){
            throw new CustomServiceException(404,"Data not Found");
        }else {

            List<SeatDTO> seatDTOList = seatList.stream()
                    .map(seat -> modelMapper.map(seatList, SeatDTO.class))
                    .toList();
            return seatDTOList;
        }
    }
    public List<SeatDTO> getSeatByTravelClass(TravelClass travelClass) {
        List<Seat> seatList = seatRepository.findByTravelClass(travelClass);
        if (seatList.isEmpty()) {
            throw new CustomServiceException(404, "Data not Found");
        } else {

            List<SeatDTO> seatDTOList = seatList.stream()
                    .map(seat -> modelMapper.map(seatList, SeatDTO.class))
                    .toList();
            return seatDTOList;
        }
    }
}
