package edu.spring.posco.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.Payment;
import edu.spring.posco.mappers.PaymentMapper;

@Repository
public class PaymentDaoImple implements PaymentDao {

	@Autowired PaymentMapper mapper;
	
	@Override
	public Integer payInsert(Payment payment) {
		// TODO Auto-generated method stub
		return mapper.payInsert(payment);
	}

	@Override
	public int payDelete(int reservcd) {
		// TODO Auto-generated method stub
		return mapper.payDelete(reservcd);
	}

}
