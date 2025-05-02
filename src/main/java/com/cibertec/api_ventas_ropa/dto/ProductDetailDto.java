package com.cibertec.api_ventas_ropa.dto;

import java.util.List;

import com.cibertec.api_ventas_ropa.model.Inventory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDetailDto {
	private int id;
	private String name;
	private double price;
	private String description;
	private String categoryName;
	private List<Inventory> inventories;
}
