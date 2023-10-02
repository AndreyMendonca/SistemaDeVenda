package com.AndreyMendonca.SistemaDeVenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AndreyMendonca.SistemaDeVenda.entities.Client;
import com.AndreyMendonca.SistemaDeVenda.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository repository;
	
	public List<Client> findAll(){
		return repository.findAll();
	}
	public Client findById(Long id) {
		Optional<Client> client = repository.findById(id);
		return client.get();
	}
}
