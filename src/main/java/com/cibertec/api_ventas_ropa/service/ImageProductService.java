package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Color;
import com.cibertec.api_ventas_ropa.model.ImageProduct;
import com.cibertec.api_ventas_ropa.repository.ImageProductrepository;

@Service
public class ImageProductService {
	
	@Autowired
	private ImageProductrepository repo;
	public List<ImageProduct> findAll(){
		return repo.findAll();
		
	}
	public void save(ImageProduct imageProduct) {
		repo.save(imageProduct);

	}
}
