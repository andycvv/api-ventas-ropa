package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Category;
import com.cibertec.api_ventas_ropa.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	public void save(Category category) {
		repo.save(category);
	}
	
	public Category findById(int id) {
		return repo.findById(id).orElse(null);
	}
	
}
