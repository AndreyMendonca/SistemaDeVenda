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
	
	public Client insert(Client client) {
		return repository.save(client);
	}
	
	public void delete(Long id) {
		repository.deleteById(id); 
	}
	
	public Client update(Long id, Client obj) {
		Client entity = repository.getReferenceById(id);
		updateData(entity,obj);
		return repository.save(entity);
	}
	public void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
		entity.setBirthday(obj.getBirthday());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
	public List<Client> findByName(String name){
		return repository.findByNameContaining(name);
	}
}
