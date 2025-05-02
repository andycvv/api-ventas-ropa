package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.dto.DashboardDto;
import com.cibertec.api_ventas_ropa.repository.UserRepository;

@Service
public class DashboardService {
	@Autowired
	private ProductService productService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderService orderService;
	
	public DashboardDto getDashboard() {
		int activedProducts = (int) productService.findAll().stream()
			    .filter(pro -> pro.isEnabled())
			    .count();
		int activedInventories = (int) inventoryService.findAll().stream()
			    .filter(inv -> inv.isEnabled())
			    .count();
		
		int totalProducts = productService.findAll().size();
		int totalCustomers = userService.findAllCustomers().size();
		int totalInventories = inventoryService.findAll().size();
		int totalOrders = orderService.findAll().size();
		
		return new DashboardDto(activedProducts, activedInventories, 
				totalProducts, totalCustomers, totalInventories, totalOrders);
	}
}
