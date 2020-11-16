package edu.spring.posco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.Theater1;
import edu.spring.posco.persistence.TheaterDao;

@Service
public class TheaterServiceImple implements TheaterService {
	
	@Autowired TheaterDao theaterDao;

	@Override
	public List<Theater1> theaterAll() {
		return theaterDao.theaterAll();
	} // end theaterAll()

	@Override
	public int insertTheater(Theater1 theater1) {
		return theaterDao.insertTheater(theater1);
	} // end insertTheater()

	@Override
	public int deleteTheater(int theatercd) {
		return theaterDao.deleteTheater(theatercd);
	} // end deleteTheater()

	@Override
	public List<Theater1> selectMovieTheater(String movienm) {
		return theaterDao.selectMovieTheater(movienm);
	} // end selectMovieTheater()

} // end class TheaterServiceImple
