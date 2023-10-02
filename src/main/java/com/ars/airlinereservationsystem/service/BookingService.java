package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.BookingDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Booking;
import com.ars.airlinereservationsystem.model.util.TravelClass;
import com.ars.airlinereservationsystem.repository.BookingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    private BookingRepository bookingRepository;
    private ModelMapper modelMapper;
    @Autowired

    public BookingService(BookingRepository bookingRepository, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.modelMapper = modelMapper;
    }
    public BookingDTO addBooking(BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findBookingByFlight_FlightCodeAndUserIdAndScheduleIdAndSeatIdAndLocalDateTime(
                bookingDTO.getFlight().getFlightCode(), bookingDTO.getPassenger().getId(),
                bookingDTO.getSchedule().getId(), bookingDTO.getSeat().getId(), bookingDTO.getLocalDateTime());
        if (booking != null) {
            throw new CustomServiceException(403, "Booking is already Exist");
        } else {
            booking = this.modelMapper.map(bookingDTO, Booking.class);
            bookingRepository.save(booking);
            BookingDTO bookingDTO1 = this.modelMapper.map(booking, BookingDTO.class);
            return bookingDTO1;
        }
    }
        public BookingDTO updateBooking(BookingDTO bookingDTO){
            Booking booking=bookingRepository.findBookingByFlight_FlightCodeAndUserIdAndScheduleIdAndSeatIdAndLocalDateTime(
                    bookingDTO.getFlight().getFlightCode(),bookingDTO.getPassenger().getId(),
                    bookingDTO.getSchedule().getId(),bookingDTO.getSeat().getId(),bookingDTO.getLocalDateTime());
            if (booking!=null){
                booking=this.modelMapper.map(bookingDTO, Booking.class);
                booking.setId(booking.getId());
                booking.setSeat(bookingDTO.getSeat());
                booking.setUser(booking.getUser());
                booking.setFlight(bookingDTO.getFlight());
                booking.setSchedule(bookingDTO.getSchedule());
                booking.setLocalDateTime(booking.getLocalDateTime());
                bookingRepository.save(booking);
                BookingDTO bookingDTO1=this.modelMapper.map(booking, BookingDTO.class);
                return bookingDTO1;

            }else {
                throw  new CustomServiceException(404,"Booking not exist you want to update");
            }

    }
    public BookingDTO cancelBooking(Long id){
        Booking booking=bookingRepository.findBookingById(id);
        if (booking!=null){
            bookingRepository.delete(booking);
            throw new CustomServiceException(200,"Booking Cancel Successfully");
        }else {
            throw  new CustomServiceException(404,"Booking not found on this booking ID");
        }
    }
   public List<BookingDTO> getUserBooking(Long id){
        List<Booking> bookingList=bookingRepository.findBookingByUserId(id);
        if(bookingList.isEmpty()){
            throw  new CustomServiceException(404,"No bookings exist on this User ID");
        }else {
            List<BookingDTO> bookingDTOList=bookingList.stream()
                    .map(booking -> modelMapper.map(bookingList, BookingDTO.class))
                    .toList();
            return bookingDTOList;
        }
   }
    public List<BookingDTO> getBookingByDateTime(LocalDateTime dateTime ){
        List<Booking> bookingList=bookingRepository.findBookingByLocalDateTime(dateTime);
        if(bookingList.isEmpty()){
            throw  new CustomServiceException(404,"No bookings exist on this Date Time");
        }else {
            List<BookingDTO> bookingDTOList=bookingList.stream()
                    .map(booking -> modelMapper.map(bookingList, BookingDTO.class))
                    .toList();
            return bookingDTOList;
        }
    }
    public List<BookingDTO> getBookingBySchedule(Long id ){
        List<Booking> bookingList=bookingRepository.findBookingByScheduleId(id);
        if(bookingList.isEmpty()){
            throw  new CustomServiceException(404,"No bookings exist on this Date Time");
        }else {
            List<BookingDTO> bookingDTOList=bookingList.stream()
                    .map(booking -> modelMapper.map(bookingList, BookingDTO.class))
                    .toList();
            return bookingDTOList;
        }
    }
    public List<BookingDTO> getUserBookingByDateTime(Long id,LocalDateTime dateTime ){
        List<Booking> bookingList=bookingRepository.findBookingByUserIdAndLocalDateTime(id, dateTime);
        if(bookingList.isEmpty()){
            throw  new CustomServiceException(404,"No bookings exist on this Date Time");
        }else {
            List<BookingDTO> bookingDTOList=bookingList.stream()
                    .map(booking -> modelMapper.map(bookingList, BookingDTO.class))
                    .toList();
            return bookingDTOList;
        }
    }
    public List<BookingDTO> getBookingBySeat(Long id){
        List<Booking> bookingList=bookingRepository.findBookingBySeatId(id);
        if(bookingList.isEmpty()){
            throw  new CustomServiceException(404,"No bookings exist on this Date Time");
        }else {
            List<BookingDTO> bookingDTOList=bookingList.stream()
                    .map(booking -> modelMapper.map(bookingList, BookingDTO.class))
                    .toList();
            return bookingDTOList;
        }
    }
    public List<BookingDTO> getBookingByTravelClass(TravelClass travelClass){
        List<Booking> bookingList=bookingRepository.findBookingBySeatTravelClass(travelClass);
        if(bookingList.isEmpty()){
            throw  new CustomServiceException(404,"No bookings exist on this Date Time");
        }else {
            List<BookingDTO> bookingDTOList=bookingList.stream()
                    .map(booking -> modelMapper.map(bookingList, BookingDTO.class))
                    .toList();
            return bookingDTOList;
        }
    }
    public List<BookingDTO> getBookingByFlight(String flightCode ){
        List<Booking> bookingList=bookingRepository.findBookingByFlight_FlightCode(flightCode);
        if(bookingList.isEmpty()){
            throw  new CustomServiceException(404,"No bookings exist on this Date Time");
        }else {
            List<BookingDTO> bookingDTOList=bookingList.stream()
                    .map(booking -> modelMapper.map(bookingList, BookingDTO.class))
                    .toList();
            return bookingDTOList;
        }
    }
}
