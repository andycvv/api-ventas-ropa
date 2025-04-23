package com.cibertec.api_ventas_ropa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.model.Size;
import com.cibertec.api_ventas_ropa.service.SizeService;

@RestController
@RequestMapping("/size")
public class SizeController {
	@Autowired
	private SizeService service;
	
	@GetMapping
	public List<Size> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody Size size) {
		service.save(size);
	}
	
	@GetMapping("/{id}")
	public Size findById(@PathVariable int id) {
		return service.findById(id);
	}
}