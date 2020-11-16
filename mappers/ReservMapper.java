package edu.spring.posco.mappers;

import org.apache.ibatis.annotations.Select;

import edu.spring.posco.domain.Reservation;


public interface ReservMapper {
	
	String SQL_RESERVATION = "insert into ${tbl_reservation} values "
		+ "(#{reservcd}, #{memberid}, #{theater}, #{seatnm}, #{showdate}, #{reservdate}, #{movienm}, #{payment}, #{price}, #{theatercd})";
	
	@Select(SQL_RESERVATION)
	Reservation reserv(Reservation reserv);
	
	String SQL_RESERVATION_CHECK = 
			"select * from ${tbl_reservation}"
			+ " where reservcd = #{reservcd} and memberid = #{memberid}";
	
	@Select(SQL_RESERVATION_CHECK)
	Reservation reservCheck(Reservation reserv);
	
	String SQL_RESERVATION_CANCEL = "delete from ${tbl_reservation} where ${col_reservcd} = #{reservcd}";
	
	@Select(SQL_RESERVATION_CANCEL)
	Reservation reservCancel(Reservation reserv);
}
