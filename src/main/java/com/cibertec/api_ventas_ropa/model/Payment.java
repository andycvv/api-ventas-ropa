package com.cibertec.api_ventas_ropa.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String transactionId;
	@CreationTimestamp
	private LocalDateTime createdAt;
	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	public enum PaymentMethod{
		TARJETA, PAYPAL
	}
	
	public enum PaymentStatus{
		FALLIDO, EXITOSO
	}
}
