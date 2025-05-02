package com.cibertec.api_ventas_ropa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Inventory;
import com.cibertec.api_ventas_ropa.model.Order;
import com.cibertec.api_ventas_ropa.model.OrderDetail;
import com.cibertec.api_ventas_ropa.model.Payment;
import com.cibertec.api_ventas_ropa.model.Order.OrderStatus;
import com.cibertec.api_ventas_ropa.repository.InventoryRepository;
import com.cibertec.api_ventas_ropa.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;
	@Autowired
	private InventoryRepository inventoryRepo;

	public List<Order> findAll() {
		return repo.findAll();
	}
	
	public void updateState(Order order) {
		Order o = repo.findById(order.getId()).orElse(null);
		o.setStatus(order.getStatus());
		repo.save(o);
	}

	@Transactional
	public void save(Order order) {
		if (order.getOrderDetails() != null) {
			for (OrderDetail detail : order.getOrderDetails()) {
				detail.setOrder(order);
				
				Inventory inv = inventoryRepo.findById(detail.getInventory().getId()).orElse(null);
				
	            if (inv.getStock() <= 0) {
	                throw new IllegalStateException("No hay stock disponible para el producto: " + inv.getId());
	            }
	            
				inv.setStock(inv.getStock() - 1);
				inventoryRepo.save(inv);
			}
			
			for (Payment p : order.getPayments()) {
				p.setOrder(order);
			}
			
			order.setStatus(OrderStatus.PAGADO);
			repo.save(order);
		}
	}
}
