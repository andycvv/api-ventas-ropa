package com.cibertec.api_ventas_ropa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.repository.ColorRepository;

@Service
public class ColorService {
	
	@Autowired
	private ColorRepository repo;
	
}
