package com.ars.airlinereservationsystem.dto;
import com.ars.airlinereservationsystem.model.AirlineCompany;
import lombok.Data;

@Data
public class AirPlaneDTO {
   private Long id;
   private  String airPlaneNo;
   private AirlineCompany airlineCompany;
}
