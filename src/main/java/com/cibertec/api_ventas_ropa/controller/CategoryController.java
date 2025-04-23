package com.cibertec.api_ventas_ropa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.model.Category;
import com.cibertec.api_ventas_ropa.service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public List<Category> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody Category category) {
		service.save(category);
	}
	
	@GetMapping("/{id}")
	public Category findById(@PathVariable int id) {
		return service.findById(id);
	}
}
