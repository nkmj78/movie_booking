package edu.spring.posco.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.Reservation;
import edu.spring.posco.mappers.ReservMapper;

@Repository
public class ReservDaoImple implements ReservDao {
	@Autowired private ReservMapper mapper;

	@Override
	public Reservation reserv(Reservation reserv) {
		
		return mapper.reserv(reserv);
	}
	
	@Override
	public Reservation reservCheck(Reservation reserv) {
		
		return mapper.reservCheck(reserv);
	}
	
	@Override
	public Reservation reservCancel(Reservation reserv) {
		
		return mapper.reservCancel(reserv);
	}

}
