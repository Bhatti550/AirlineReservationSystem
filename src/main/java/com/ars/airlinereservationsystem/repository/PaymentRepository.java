package com.ars.airlinereservationsystem.repository;

import com.ars.airlinereservationsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findPaymentById(Long id);
    List<Payment> findPaymentByBooking_Id(Long id);
    List<Payment> findPaymentsByPaymentStatus(boolean paymentStatus);
}
