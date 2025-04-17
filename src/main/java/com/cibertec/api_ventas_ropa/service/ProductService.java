package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Product;
import com.cibertec.api_ventas_ropa.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> findAll() {
		return repo.findAll();
	}
	public void save(Product product) {
		repo.save(product);
	}
	public Product findById(int id) {
		return repo.findById(id).orElse(null);
	}
}

