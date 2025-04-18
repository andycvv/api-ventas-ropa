package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Order;
import com.cibertec.api_ventas_ropa.repository.OrderRepository;

@Service    
public class OrderService {

	@Autowired
	private OrderRepository repo;
	
	public List<Order> findAll() {
		return repo.findAll();
	}
	
	public void save(Order order) {
		repo.save(order);
	}
}
