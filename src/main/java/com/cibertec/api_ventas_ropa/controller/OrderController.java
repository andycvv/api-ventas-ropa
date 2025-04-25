package com.cibertec.api_ventas_ropa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.model.Order;
import com.cibertec.api_ventas_ropa.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@GetMapping
	@PreAuthorize("hasAnyRole('ADMIN', 'CLIENTE')")
	public List<Order> findAll() {
		return service.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasRole('CLIENTE')")
	public void save(@RequestBody Order order) {
		service.save(order);
	}
}
