package com.AndreyMendonca.SistemaDeVenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AndreyMendonca.SistemaDeVenda.entities.Product;
import com.AndreyMendonca.SistemaDeVenda.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		List<Product> products = repository.findAll();
		return products;
	}
	
	public Product findById(Long id) {
		Optional<Product> product = repository.findById(id);
		return product.get();
	}
	public Product insert(Product product) {
		return repository.save(product);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Product update(Long id, Product product) {
		Product entity = repository.getReferenceById(id);
		updateData(entity, product);
		return repository.save(entity);
	}
	public void updateData(Product entity, Product product) {
		entity.setName(product.getName());
		entity.setCategory(product.getCategory());
		entity.setDescription(product.getDescription());
		entity.setPrice(product.getPrice());
		entity.setStock(product.getStock());
		entity.setActive(product.getActive());
	}
	public Product updateActive(Long id) {
		Product product = findById(id);
		if(product.getActive()) {
			product.setActive(false);
			System.out.println("deixei falso");
		}else {
			product.setActive(true);
		}
		return repository.save(product);
	}
}
