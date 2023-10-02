package com.ars.airlinereservationsystem.service;

import com.ars.airlinereservationsystem.dto.PaymentDTO;
import com.ars.airlinereservationsystem.exception.CustomServiceException;
import com.ars.airlinereservationsystem.model.Payment;
import com.ars.airlinereservationsystem.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private ModelMapper modelMapper;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository, ModelMapper modelMapper) {
        this.paymentRepository = paymentRepository;
        this.modelMapper = modelMapper;
    }
    public PaymentDTO addPayment(PaymentDTO paymentDTO){
        Payment payment=paymentRepository.findPaymentById(paymentDTO.getId());
        if(payment!=null){
            throw  new CustomServiceException(403,"Payment is already done");
        }else {
            payment=this.modelMapper.map(paymentDTO, Payment.class);
            paymentRepository.save(payment);
            PaymentDTO paymentDTO1=this.modelMapper.map(payment, PaymentDTO.class);
            return paymentDTO1;
        }
    }
    public PaymentDTO updatePayment(PaymentDTO paymentDTO){
        Payment payment=paymentRepository.findPaymentById(paymentDTO.getId());
        if(payment!=null){
            payment=this.modelMapper.map(paymentDTO, Payment.class);
            paymentRepository.save(payment);
            PaymentDTO paymentDTO1=this.modelMapper.map(payment, PaymentDTO.class);
            return paymentDTO1;

        }else {
            throw  new CustomServiceException(404,"Payment not found");
        }
    }
    public PaymentDTO deletePayment(Long paymentId){
        Payment payment=paymentRepository.findPaymentById(paymentId);
        if(payment!=null){
            paymentRepository.delete(payment);
           throw new CustomServiceException(200,"Payment transaction Successfully deleted");

        }else {
            throw  new CustomServiceException(404,"Payment not found");
        }
    }
    public List<PaymentDTO> getPaymentByStatus(boolean paymentStatus){
        List<Payment> paymentList=paymentRepository.findPaymentsByPaymentStatus(paymentStatus);
       if (paymentList.isEmpty()){
           throw  new CustomServiceException(404,"Payment not found");
        }else {
           List<PaymentDTO> paymentDTOList=paymentList.stream()
                   .map(payment -> modelMapper.map(paymentList, PaymentDTO.class))
                   .toList();
           return paymentDTOList;
        }
    }
    public List<PaymentDTO> getPaymentByBookingId(Long bookingId) {
        List<Payment> paymentList = paymentRepository.findPaymentByBooking_Id(bookingId);
        if (paymentList.isEmpty()) {
            throw new CustomServiceException(404, "Payment not found");
        } else {
            List<PaymentDTO> paymentDTOList = paymentList.stream()
                    .map(payment -> modelMapper.map(paymentList, PaymentDTO.class))
                    .toList();
            return paymentDTOList;
        }
    }
}
