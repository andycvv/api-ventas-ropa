package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.ImageProduct;
import com.cibertec.api_ventas_ropa.model.Inventory;
import com.cibertec.api_ventas_ropa.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository repo;

	public List<Inventory> findAll() {
		return repo.findAll();
	}

	public void save(Inventory inventory) {
		if(inventory.getImageProducts()!=null) {
			for(ImageProduct img : inventory.getImageProducts()) {
				img.setInventory(inventory);
			}
		}
		repo.save(inventory);
	}
}
