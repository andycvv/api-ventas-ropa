package com.cibertec.api_ventas_ropa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cibertec.api_ventas_ropa.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> { 
}

