package com.AndreyMendonca.SistemaDeVenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AndreyMendonca.SistemaDeVenda.entities.Payment;
import com.AndreyMendonca.SistemaDeVenda.services.PaymentService;

@RestController
@RequestMapping(value="payments")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<List<Payment>> findAll(){
		List<Payment> payments = service.findAll();
		return ResponseEntity.ok().body(payments);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id){
		Payment payment = service.findById(id);
		return ResponseEntity.ok().body(payment);
	}
}
