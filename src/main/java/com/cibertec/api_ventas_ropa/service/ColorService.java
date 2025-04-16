package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Color;
import com.cibertec.api_ventas_ropa.repository.ColorRepository;

@Service
public class ColorService {
	
	@Autowired
	private ColorRepository repo;
	
	public List<Color> findAll(){
		return repo.findAll();
	}
	
	public void save(Color color) {
		repo.save(color);
	}
}
