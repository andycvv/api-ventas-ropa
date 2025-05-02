package com.cibertec.api_ventas_ropa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.api_ventas_ropa.model.User;
import com.cibertec.api_ventas_ropa.repository.RoleRepository;
import com.cibertec.api_ventas_ropa.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    user.setRole(roleRepository.findByName("CLIENTE").orElse(null));
	    User usuario = userRepository.save(user);
	    return usuario;
	}
	
	@GetMapping("/getMyUser")
	public User getMyUser(Authentication auth) {
		return userRepository.findByEmail(auth.getName()).orElse(null);
	}
}
