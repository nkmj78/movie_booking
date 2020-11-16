package edu.spring.posco.persistence;

import edu.spring.posco.domain.Reservation;

public interface ReservDao {
	
	Reservation reserv(Reservation reserv);
	Reservation reservCheck(Reservation reserv);
	Reservation reservCancel(Reservation reserv);
}
