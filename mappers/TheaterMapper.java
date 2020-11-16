package edu.spring.posco.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.spring.posco.domain.Theater1;

public interface TheaterMapper {
	
	String SQL_THEATER_ALL = 
			"select * from ${tbl_theater1}";
	String SQL_THEATER_INSERT = 
			"insert into ${tbl_theater1} "
			+ "values ( #{theatercd}, #{moviesite}, #{movienm}, #{starttime}, #{showdate}, #{seat}, #{price} )";
	String SQL_THEATER_DELETE = 
			"delete from ${tbl_theater1} "
			+ "where ${col_theatercd} = #{theatercd}";
	String SQL_THEATER_SELECT_MOVIE = 
			"select * from ${tbl_theater1} "
			+ "where ${col_movienm} = #{movienm}"; 
	
	@Select(SQL_THEATER_ALL)
	List<Theater1> theaterAll();
	
	@Insert(SQL_THEATER_INSERT)
	int insertTheater(Theater1 theater1);
	
	@Delete(SQL_THEATER_DELETE)
	int deleteTheater(int theatercd);
	
	@Select(SQL_THEATER_SELECT_MOVIE)
	List<Theater1> selectMovieTheater(String movienm); 
	
	
} // end interface TheaterMapper
