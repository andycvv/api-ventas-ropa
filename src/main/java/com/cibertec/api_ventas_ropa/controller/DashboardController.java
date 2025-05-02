package com.cibertec.api_ventas_ropa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.dto.DashboardDto;
import com.cibertec.api_ventas_ropa.service.DashboardService;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
	@Autowired
	private DashboardService service;
	
	@GetMapping
	public DashboardDto getDashboard() {
		return service.getDashboard();
	}
}
