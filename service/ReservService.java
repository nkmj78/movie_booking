package edu.spring.posco.service;

import edu.spring.posco.domain.Reservation;

public interface ReservService {
	
	Reservation reserv(Reservation reserv);
	Reservation reservCheck(Reservation reserv);
	Reservation reservCancel(Reservation reserv);
}
