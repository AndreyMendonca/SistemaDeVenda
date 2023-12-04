package com.AndreyMendonca.SistemaDeVenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AndreyMendonca.SistemaDeVenda.entities.Payment;
import com.AndreyMendonca.SistemaDeVenda.repositories.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepository repository;
	
	public List<Payment> findAll(){
		List<Payment> payments = repository.findAll();
		return payments;
	}
	
	public Payment findById(Long id) {
		Optional<Payment> payment = repository.findById(id);
		return payment.get();
	}
	
	public Payment insert(Payment payment) {
		return repository.save(payment);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
