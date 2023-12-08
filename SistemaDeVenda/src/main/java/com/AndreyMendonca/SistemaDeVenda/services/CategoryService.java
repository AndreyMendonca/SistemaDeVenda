package com.AndreyMendonca.SistemaDeVenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AndreyMendonca.SistemaDeVenda.entities.Category;
import com.AndreyMendonca.SistemaDeVenda.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		List<Category> categories = repository.findAll();
		return categories;
	}
	
	public Category findById(Long id) {
		Optional<Category> category = repository.findById(id);
		return category.get();
	}
	
	public Category insert(Category category) {
		if(category.getActive() == null) {
			category.setActive(true);
		}
		return repository.save(category);
	}
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Category updateActive(Long id) {
		Category category = findById(id);
		if(category.getActive()) {
			category.setActive(false);
			System.out.println("deixei falso");
		}else {
			category.setActive(true);
		}
		return repository.save(category);
	}
	
	public List<Category> findByName(String name){
		return repository.findByNameContaining(name);
	}
}
