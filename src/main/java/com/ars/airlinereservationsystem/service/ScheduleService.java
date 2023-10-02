package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.ScheduleDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Schedule;
import com.ars.airlinereservationsystem.repository.ScheduleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;
    private ModelMapper modelMapper;
    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.modelMapper = modelMapper;
    }
    public ScheduleDTO addSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule=scheduleRepository.findScheduleById(scheduleDTO.getId());
        if (schedule!=null){
            throw  new CustomServiceException(403,"Data already exist");
        }else {
            schedule=this.modelMapper.map(scheduleDTO,Schedule.class);
            scheduleRepository.save(schedule);
            ScheduleDTO scheduleDTO1=this.modelMapper.map(schedule, ScheduleDTO.class);
            return scheduleDTO1;
        }
    }
    public ScheduleDTO updateSchedule(ScheduleDTO scheduleDTO){
        Schedule schedule=scheduleRepository.findScheduleById(scheduleDTO.getId());
        if (schedule!=null){
            schedule=this.modelMapper.map(scheduleDTO,Schedule.class);
            schedule.setId(schedule.getId());
            schedule.setFlight(scheduleDTO.getFlight());
            schedule.setAirPlane(scheduleDTO.getAirPlane());
            schedule.setDepartureTime(scheduleDTO.getDepartureTime());
            schedule.setArrivalTime(scheduleDTO.getArrivalTime());
            scheduleRepository.save(schedule);
            ScheduleDTO scheduleDTO1=this.modelMapper.map(schedule, ScheduleDTO.class);
            return scheduleDTO1;

        }else {
            throw  new CustomServiceException(404,"Data nto Found");
        }
    }
    public ScheduleDTO getSchedule(Long id){
        Schedule schedule=scheduleRepository.findScheduleById(id);
        if (schedule!=null){
            ScheduleDTO scheduleDTO=this.modelMapper.map(schedule, ScheduleDTO.class);
            return scheduleDTO;
        }else {
            throw new CustomServiceException(404,"Data not found");
        }
    }
    public List<ScheduleDTO> getScheduleByFlight(Long id){
        List<Schedule> scheduleList=scheduleRepository.findScheduleByFlight_Id(id);
        if (scheduleList.isEmpty()){
            throw new CustomServiceException(404,"No flight Schedule against this flight");
        }else {
            List<ScheduleDTO> scheduleDTOList=scheduleList.stream()
                    .map(schedule -> modelMapper.map(scheduleList, ScheduleDTO.class))
                    .toList();
            return scheduleDTOList;
        }
    }
    public List<ScheduleDTO> getScheduleByDepartureDateTimeAndArrivalDateTime(LocalDateTime departureTime, LocalDateTime arrivalTime){
        List<Schedule> scheduleList=scheduleRepository.findSchedulesByDepartureTimeAndArrivalTime(departureTime,arrivalTime);
        if ((scheduleList.isEmpty())){
            throw new CustomServiceException(404,"Data not found");
        }else {
            List<ScheduleDTO> scheduleDTOList=scheduleList.stream()
                    .map(schedule -> modelMapper.map(scheduleList,ScheduleDTO.class))
                    .toList();
            return scheduleDTOList;
        }
    }
    public ScheduleDTO deleteSchedule(Long id){
        Schedule schedule=scheduleRepository.findScheduleById(id);
        if (schedule!=null){
            scheduleRepository.delete(schedule);
            throw new CustomServiceException(200,"Schedule is deleted Successfully");
        }else {
            throw new CustomServiceException(404,"Data not found");
        }
    }
}
