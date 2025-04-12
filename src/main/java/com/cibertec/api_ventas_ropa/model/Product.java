package com.cibertec.api_ventas_ropa.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	    private String description;
	    private double price;
	    @CreationTimestamp
	    private LocalDateTime createdAt;
}
