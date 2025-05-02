package com.cibertec.api_ventas_ropa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.dto.ProductDetailDto;
import com.cibertec.api_ventas_ropa.dto.ProductPreviewDto;
import com.cibertec.api_ventas_ropa.model.ImageProduct;
import com.cibertec.api_ventas_ropa.model.Inventory;
import com.cibertec.api_ventas_ropa.model.Product;
import com.cibertec.api_ventas_ropa.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;

	public List<Product> findAll() {
		return repo.findAll();
	}
	public void save(Product product) {
		repo.save(product);
	}
	public Product findById(int id) {
		return repo.findById(id).orElse(null);
	}
	public List<ProductPreviewDto> findAllPreviews() {
		return repo.findAll().stream()
				.filter(Product::isEnabled)
				.map(product -> {
					List<String> images = product.getInventories().stream()
						.filter(Inventory::isEnabled)
                        .flatMap(inv -> inv.getImageProducts().stream())
                        .map(ImageProduct::getUrl)
                        .toList();
					
					List<String> colors = product.getInventories().stream()
							.filter(Inventory::isEnabled)
							.map(i -> i.getColor().getName())
							.toList();
					
					ProductPreviewDto p = new ProductPreviewDto();
					p.setId(product.getId());
					p.setImages(images);
					p.setColors(colors);
					p.setCategoryName(product.getCategory().getName());
					p.setDescription(product.getDescription());
					p.setGender(product.getGender());
					p.setName(product.getName());
					p.setPrice(product.getPrice());
					
					return p;
				})
				.collect(Collectors.toList());
	}
	public ProductDetailDto findDetailById(int id) {
		return repo.findById(id)
	            .map(product -> {
	                List<Inventory> inventories = product.getInventories().stream()
	                		.filter(i -> i.isEnabled()).toList();
	                
	                ProductDetailDto p = new ProductDetailDto();
	                p.setId(product.getId());
	                p.setName(product.getName());
	                p.setCategoryName(product.getCategory().getName());
	                p.setPrice(product.getPrice());
	                p.setDescription(product.getDescription());
	                p.setInventories(inventories);
	                
	                return p;
	            })
	            .orElse(null);
	}
}

