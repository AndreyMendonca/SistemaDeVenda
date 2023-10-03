package com.AndreyMendonca.SistemaDeVenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AndreyMendonca.SistemaDeVenda.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
