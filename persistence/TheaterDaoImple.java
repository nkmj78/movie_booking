package edu.spring.posco.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.Theater1;
import edu.spring.posco.mappers.TheaterMapper;



@Repository
public class TheaterDaoImple implements TheaterDao {
	
	
	@Autowired TheaterMapper mapper;

	@Override
	public List<Theater1> theaterAll() {
		return mapper.theaterAll();
	} // end thaterAll()

	@Override
	public int insertTheater(Theater1 theater1) {
		return mapper.insertTheater(theater1);
	} // end insertTheater()

	@Override
	public int deleteTheater(int theatercd) {
		return mapper.deleteTheater(theatercd);
	} // end deleteTheater()

	@Override
	public List<Theater1> selectMovieTheater(String movienm) {
		return mapper.selectMovieTheater(movienm);
	} // end selectMovieTheater()

} // end class TheaterDaoImple
