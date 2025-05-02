package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.User;
import com.cibertec.api_ventas_ropa.repository.RoleRepository;
import com.cibertec.api_ventas_ropa.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> findAllCustomers() {
		return userRepository.findByRole(roleRepository.findByName("CLIENTE").orElse(null));
	}
}
