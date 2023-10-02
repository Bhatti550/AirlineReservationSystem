package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.RouteDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Route;
import com.ars.airlinereservationsystem.repository.RouteRepository;
import org.hibernate.sql.exec.spi.StandardEntityInstanceResolver;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;

    private  final ModelMapper modelMapper;
    @Autowired
    public RouteService(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }
    public RouteDTO addRoute(RouteDTO routeDTO){
        Route route=routeRepository.findRoutesById(routeDTO.getId());
        if (route!=null){
            throw new CustomServiceException(403,"Records already exist");
        }else {
            route=this.modelMapper.map(routeDTO, Route.class);
            routeRepository.save(route);
            RouteDTO routeDTO1=this.modelMapper.map(route,RouteDTO.class);
            return routeDTO1;
        }
    }
    public List<RouteDTO> getRoutesByAirlineCompany(String name){
        List<Route> routeList=routeRepository.findRouteByAirlineCompany_Name(name);
        if (routeList.isEmpty()){
            throw new CustomServiceException(404,"Routes not Found");
        } else {
            List<RouteDTO> routeDTOList=routeList.stream()
                    .map(route -> modelMapper.map(routeList, RouteDTO.class))
                    .toList();
            return routeDTOList;
        }
    }
    public RouteDTO updateRoute(RouteDTO routeDTO){
        Route route=routeRepository.findRoutesById(routeDTO.getId());
        if (route!=null){
            route=this.modelMapper.map(routeDTO, Route.class);
            route.setId(route.getId());
            route.setAirlineCompany(routeDTO.getAirlineCompany());
            route.setDepartureLocation(routeDTO.getDepartureLocation());
            route.setDestinationLocation(routeDTO.getDestinationLocation());
            routeRepository.save(route);
            RouteDTO routeDTO1=this.modelMapper.map(route,RouteDTO.class);
            return routeDTO1;
        }
        else {
            throw  new CustomServiceException(404,"Route can't found and update.");
        }
    }
    public  RouteDTO deleteRoute(Long routeId){
        Route route=routeRepository.findRoutesById(routeId);
        if (route!=null){
            routeRepository.delete(route);
            RouteDTO routeDTO=this.modelMapper.map(route, RouteDTO.class);
            return routeDTO;
        }else {
            throw  new CustomServiceException(404,"Route you want to delete is not exist");
        }
    }
    public List<RouteDTO> getCustomRoute(String departureLocation, String destinationLocation){
        List<Route> routeList=routeRepository.findRouteByDepartureLocationAndDestinationLocation(departureLocation,destinationLocation);
        if(routeList.isEmpty()){
            throw new CustomServiceException(404,"Routes not found");
        }else {
            List<RouteDTO> routeDTOList=routeList.stream()
                    .map(route -> modelMapper.map(routeList,RouteDTO.class))
                    .toList();
            return routeDTOList;
        }
    }

}
