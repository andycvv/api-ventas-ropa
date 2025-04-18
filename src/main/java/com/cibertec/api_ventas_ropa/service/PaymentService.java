package com.cibertec.api_ventas_ropa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.api_ventas_ropa.model.Payment;
import com.cibertec.api_ventas_ropa.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository repo;
	
	public List<Payment> findAll() {
		return repo.findAll();
	}
	
	public void save(Payment payment) {
		repo.save(payment);
	}
}
