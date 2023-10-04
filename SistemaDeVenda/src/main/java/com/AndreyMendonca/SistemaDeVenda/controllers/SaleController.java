package com.AndreyMendonca.SistemaDeVenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AndreyMendonca.SistemaDeVenda.entities.Sale;
import com.AndreyMendonca.SistemaDeVenda.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
		List<Sale> sales = service.findAll();
		return ResponseEntity.ok().body(sales);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sale> findById(@PathVariable Long id) {
		Sale sale = service.findById(id);
		return ResponseEntity.ok().body(sale);
	}
}
