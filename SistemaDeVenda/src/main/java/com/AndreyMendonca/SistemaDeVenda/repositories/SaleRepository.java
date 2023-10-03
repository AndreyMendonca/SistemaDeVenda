package com.AndreyMendonca.SistemaDeVenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AndreyMendonca.SistemaDeVenda.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale,Long> {

}
