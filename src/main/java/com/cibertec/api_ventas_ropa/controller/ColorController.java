package com.cibertec.api_ventas_ropa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.model.Color;
import com.cibertec.api_ventas_ropa.service.ColorService;

@RestController
@RequestMapping("/color")
public class ColorController {

	@Autowired
	private ColorService service;
	
	@GetMapping
	public List<Color> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody Color color) {
		service.save(color);
	}
	
	@GetMapping("/{id}")
	public Color findById(@PathVariable int id) {
		return service.findById(id);
	}
}
