package com.cibertec.api_ventas_ropa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.api_ventas_ropa.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String username);
}
