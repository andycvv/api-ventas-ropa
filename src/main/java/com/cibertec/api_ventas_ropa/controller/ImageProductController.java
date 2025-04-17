package com.cibertec.api_ventas_ropa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.model.ImageProduct;

import com.cibertec.api_ventas_ropa.service.ImageProductService;


@RestController
@RequestMapping("/imageproduct")
public class ImageProductController {
	@Autowired
	private ImageProductService service;
	@GetMapping
	public List<ImageProduct> findAll(){
		return service.findAll();
	}
	@PostMapping
	public void save(@RequestBody ImageProduct imageproduct) {
		service.save(imageproduct);
	}
}