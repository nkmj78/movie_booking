package edu.spring.posco.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import edu.spring.posco.domain.Payment;


public interface PaymentMapper {

	String SQL_PAYMENT_INSERT = "insert into ${tbl_payment} values "
			+ "(#{paycode}, #{payment}, #{price}, #{memberid}, #{reservcd})";
		
	String SQL_PAYMENT_DELETE = "delete from ${tbl_payment} "
			+ "where ${col_reservcd} = #{reservcd}";
	
	
	@Insert(SQL_PAYMENT_INSERT)
	int payInsert(Payment payment);
	
	@Delete(SQL_PAYMENT_DELETE)
	int payDelete(int reservcd);
		
}
