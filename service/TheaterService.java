package edu.spring.posco.service;

import java.util.List;

import edu.spring.posco.domain.Theater1;

public interface TheaterService {
	
	List<Theater1> theaterAll();
	int insertTheater(Theater1 theater1);
	int deleteTheater(int theatercd);
	List<Theater1> selectMovieTheater(String movienm);
	

} // end interface TheaterService
