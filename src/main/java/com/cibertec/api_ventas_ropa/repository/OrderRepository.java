package com.cibertec.api_ventas_ropa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.api_ventas_ropa.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
