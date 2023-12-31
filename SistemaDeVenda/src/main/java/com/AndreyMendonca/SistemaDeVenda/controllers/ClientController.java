package com.AndreyMendonca.SistemaDeVenda.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.AndreyMendonca.SistemaDeVenda.entities.Client;
import com.AndreyMendonca.SistemaDeVenda.services.ClientService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> clients = service.findAll();
		return ResponseEntity.ok().body(clients);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client client = service.findById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@PostMapping(value = "/insert")
	public ResponseEntity<Client> insert(@RequestBody Client client){
		client = service.insert(client);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
		return ResponseEntity.created(uri).body(client);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/name/{name}")
	public ResponseEntity<List<Client>> findByName(@PathVariable String name){
		List<Client> clients = service.findByName(name);
		return ResponseEntity.ok().body(clients);
	}
	
	@PutMapping(value="/active/{id}")
	public void updateActive(@PathVariable Long id){
		service.updateActive(id);
	}
}
