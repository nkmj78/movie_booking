package edu.spring.posco.mappers;

import org.apache.ibatis.annotations.Select;
import edu.spring.posco.domain.Member;

public interface MemberMapper {
	String SQL_SIGNUP_MEMBER = "insert into ${tbl_member} values (#{memberid}, #{pwd}, #{pwdcheck}, #{nickname}, #{email})";
	
	@Select(SQL_SIGNUP_MEMBER)
	Member signup(Member member);
	
	
	
	String SQL_SIGNIN_MEMBER = 
			"select * from ${tbl_member}"
			+ " where ${col_memberid} = #{memberid} and ${col_pwd} = #{pwd}";
	
	@Select(SQL_SIGNIN_MEMBER)
	Member signin(Member member);
	
	
	String SQL_UPDATE_MEMBER = "update ${tbl_member} set ${col_pwd} = #{pwd}, ${col_nickname} = #{nickname}, ${col_email} = #{email} "
			+ " where ${col_memberid} = #{memberid}";
	
	@Select(SQL_UPDATE_MEMBER)
	Member update(Member member);
	
	
	
	
	
	String SQL_DELETE_MEMBER = "delete from ${tbl_member} where ${col_memberid} = #{memberid}";
	
	@Select(SQL_DELETE_MEMBER)
	Member delete(Member member);
	
	
	
	
	
	String SQL_CHECKID_MEMBER = 
			"select * from ${tbl_member}" +
			" where ${col_memberid} = #{memberid}";
			
	@Select(SQL_CHECKID_MEMBER)
	Member signcheck(String memberid);
	
	
	
}
