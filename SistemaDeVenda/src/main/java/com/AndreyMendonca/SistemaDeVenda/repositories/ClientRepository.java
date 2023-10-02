package com.AndreyMendonca.SistemaDeVenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AndreyMendonca.SistemaDeVenda.entities.Client;

public interface ClientRepository extends JpaRepository<Client,Long>{

}
