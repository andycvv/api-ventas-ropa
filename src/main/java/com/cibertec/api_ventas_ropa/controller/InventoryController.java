package com.cibertec.api_ventas_ropa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.model.Inventory;
import com.cibertec.api_ventas_ropa.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
	private InventoryService service;

	@GetMapping
	public List<Inventory> findAll() {
		return service.findAll();
	}

	@PostMapping
	public void save(@RequestBody Inventory inventory) {
		service.save(inventory);
	}
	
	@GetMapping("/{id}")
	public Inventory findById(@PathVariable int id) {
		return service.findById(id);
	}
}
