package edu.spring.posco.persistence;

import edu.spring.posco.domain.Payment;

public interface PaymentDao {

	Integer payInsert(Payment payment);

	int payDelete(int reservcd);
}
