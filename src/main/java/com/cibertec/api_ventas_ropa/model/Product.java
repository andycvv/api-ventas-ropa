package com.cibertec.api_ventas_ropa.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
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
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(length = 1000)
	private String description;
	private String gender;
	private double price;
	private boolean enabled;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDateTime createdAt;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Inventory> inventories;
}
