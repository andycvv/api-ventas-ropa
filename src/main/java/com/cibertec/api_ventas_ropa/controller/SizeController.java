package com.cibertec.api_ventas_ropa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.service.SizeService;

@RestController
@RequestMapping("/size")
public class SizeController {
	@Autowired
	private SizeService service;

}
