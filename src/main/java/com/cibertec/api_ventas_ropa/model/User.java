package com.cibertec.api_ventas_ropa.model;

import java.util.List;

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
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String username;
	private String email;
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy = "userId")
	private List<Address> addresses;
	
	@OneToMany(mappedBy = "user")
	private List<Order> Orders;
}
