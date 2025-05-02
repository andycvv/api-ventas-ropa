package com.cibertec.api_ventas_ropa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DashboardDto {
	private int activedProducts;
	private int activedInventories;
	
	private int totalProducts;
	private int totalCustomers;
	private int totalInventories;
	private int totalOrders;
}
