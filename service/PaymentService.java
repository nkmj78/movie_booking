package edu.spring.posco.service;

import edu.spring.posco.domain.Payment;

public interface PaymentService {

	int payInsert(Payment payment);
	
	int payDelete(int reservcd);
	
}
