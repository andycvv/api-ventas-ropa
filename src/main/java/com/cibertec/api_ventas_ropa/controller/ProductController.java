package com.cibertec.api_ventas_ropa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.dto.ProductDetailDto;
import com.cibertec.api_ventas_ropa.dto.ProductPreviewDto;
import com.cibertec.api_ventas_ropa.model.Product;
import com.cibertec.api_ventas_ropa.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<Product> findAll() {
        return service.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public void save(@RequestBody Product product) {
        service.save(product);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id) {
    	return service.findById(id);
    }
    
    @PreAuthorize("hasRole('CLIENTE')")
    @GetMapping("/preview")
    public List<ProductPreviewDto> findProductPreviews() {
    	return service.findAllPreviews();
    }
    
    @PreAuthorize("hasRole('CLIENTE')")
    @GetMapping("/detail/{id}")
    public ProductDetailDto findProductDetailById(@PathVariable int id) {
    	return service.findDetailById(id);
    }
}
