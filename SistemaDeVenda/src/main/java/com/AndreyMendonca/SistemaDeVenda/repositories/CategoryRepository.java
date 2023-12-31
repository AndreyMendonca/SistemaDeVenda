package com.AndreyMendonca.SistemaDeVenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AndreyMendonca.SistemaDeVenda.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	
	List<Category> findByNameContaining(String name);
}
