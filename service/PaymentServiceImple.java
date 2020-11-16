package edu.spring.posco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.Payment;
import edu.spring.posco.persistence.PaymentDao;

@Service
public class PaymentServiceImple implements PaymentService {

	@Autowired PaymentDao paymentDao;

	@Override
	public int payInsert(Payment payment) {
		// TODO Auto-generated method stub
		return paymentDao.payInsert(payment);
	}

	@Override
	public int payDelete(int reservcd) {
		// TODO Auto-generated method stub
		return paymentDao.payDelete(reservcd);
	}
	

}
