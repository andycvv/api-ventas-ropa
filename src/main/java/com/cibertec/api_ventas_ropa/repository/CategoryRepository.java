package com.cibertec.api_ventas_ropa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.api_ventas_ropa.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
