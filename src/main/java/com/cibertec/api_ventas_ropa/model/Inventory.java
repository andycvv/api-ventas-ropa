package com.cibertec.api_ventas_ropa.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int stock;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "size_id")
	private Size size;
	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@OneToMany(mappedBy = "inventory")
	private List<ImageProduct> imageProducts;
}
