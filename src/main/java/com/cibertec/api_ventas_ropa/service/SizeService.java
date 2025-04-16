package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Size;
import com.cibertec.api_ventas_ropa.repository.SizeRepository;

@Service
public class SizeService {
	@Autowired
	private SizeRepository repo;
	
	public List<Size> findAll(){
		return repo.findAll();
	}
	
	public void save(Size size) {
		repo.save(size);
	}
}



