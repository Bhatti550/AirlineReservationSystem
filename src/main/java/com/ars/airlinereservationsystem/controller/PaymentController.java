package com.ars.airlinereservationsystem.controller;

import com.ars.airlinereservationsystem.dto.PaymentDTO;
import com.ars.airlinereservationsystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    @Autowired
    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping("/add")
    public ResponseEntity<PaymentDTO> addPayment(@RequestBody PaymentDTO paymentDTO){
        PaymentDTO paymentDTO1=paymentService.addPayment(paymentDTO);
        return new ResponseEntity<PaymentDTO>(paymentDTO1, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<PaymentDTO> updatePayment(@RequestBody PaymentDTO paymentDTO){
        PaymentDTO paymentDTO1=paymentService.updatePayment(paymentDTO);
        return new ResponseEntity<PaymentDTO>(paymentDTO1, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<PaymentDTO> deletePayment(@RequestParam Long paymentId){
        PaymentDTO paymentDTO=paymentService.deletePayment(paymentId);
        return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<List<PaymentDTO>> updatePayment(@RequestParam Long bookingId){
        List<PaymentDTO> paymentDTOList=paymentService.getPaymentByBookingId(bookingId);
        return new ResponseEntity<List<PaymentDTO>>(paymentDTOList, HttpStatus.FOUND);
    }
    @GetMapping("/get-by-status")
    public ResponseEntity<List<PaymentDTO>> getPaymentByStatus(@RequestParam boolean status){
        List<PaymentDTO> paymentDTOList=paymentService.getPaymentByStatus(status);
        return new ResponseEntity<List<PaymentDTO>>(paymentDTOList, HttpStatus.FOUND);
    }
}
