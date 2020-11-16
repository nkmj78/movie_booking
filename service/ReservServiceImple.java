package edu.spring.posco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.Reservation;
import edu.spring.posco.persistence.ReservDao;

@Service
public class ReservServiceImple implements ReservService {
	
	@Autowired private ReservDao reservDao;

	@Override
	public Reservation reserv(Reservation reserv) {
		
		return reservDao.reserv(reserv);
	}
	
	@Override
	public Reservation reservCheck(Reservation reserv) {
		
		return reservDao.reservCheck(reserv);
	}
	
	@Override
	public Reservation reservCancel(Reservation reserv) {
		
		return reservDao.reservCancel(reserv);
	}

}
