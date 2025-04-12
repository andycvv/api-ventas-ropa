package com.cibertec.api_ventas_ropa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.api_ventas_ropa.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
