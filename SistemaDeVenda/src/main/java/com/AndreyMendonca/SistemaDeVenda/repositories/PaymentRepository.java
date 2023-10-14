package com.AndreyMendonca.SistemaDeVenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AndreyMendonca.SistemaDeVenda.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
