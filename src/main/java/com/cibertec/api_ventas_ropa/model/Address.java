package com.cibertec.api_ventas_ropa.model;

import java.util.List;

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

@Entity
@Getter
@Setter
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 255)
	private String street;
	@Column(length = 100)
	private String city;
	@Column(length = 100)
	private String country;
	@Column(length = 255)
	private String zipCode;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;
	
	@OneToMany(mappedBy = "address")
	@JsonIgnore
	private List<Order> Orders;
	
}
