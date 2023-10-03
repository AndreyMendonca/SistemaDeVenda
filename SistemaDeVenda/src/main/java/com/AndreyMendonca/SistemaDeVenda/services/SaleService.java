package com.AndreyMendonca.SistemaDeVenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AndreyMendonca.SistemaDeVenda.entities.Sale;
import com.AndreyMendonca.SistemaDeVenda.repositories.SaleRepository;

@Service
public class SaleService {
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findAll(){
		List<Sale> sales = repository.findAll();
		return sales;
	}
	
	public Sale findById(Long id) {
		Optional<Sale> sale = repository.findById(id);
		return sale.get();
	}
	
}
