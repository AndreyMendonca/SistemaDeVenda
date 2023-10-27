package com.AndreyMendonca.SistemaDeVenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AndreyMendonca.SistemaDeVenda.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{
	
	List<Client> findByNameContaining(String name);
}
