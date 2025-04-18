package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Address;
import com.cibertec.api_ventas_ropa.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;
	
	public List<Address> findAll() {
		return repo.findAll();
	}
	
	public void save(Address address) {
		repo.save(address);
	}
}
