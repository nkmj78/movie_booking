package edu.spring.posco.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.posco.domain.Rvlike;

public interface RvlikeMapper {
	
	String SQL_RVLIKE_LIKE_CHECK =
			"update ${tbl_rvlike} "
			+ "set ${col_likecheck} = ${col_likecheck} + 1 "
			+ "where ${col_memberid} = #{memberid} and ${col_rvcode} = #{rvcode}";
	
	String SQL_RVLIKE_LIKE_CHECK_CANCEL = 
			"update ${tbl_rvlike} "
			+ "set ${col_likecheck} = 0 "
			+ "where ${col_memberid} = #{memberid} and ${col_rvcode} = #{rvcode}";
	
	String SQL_RVLIKE_SELECT_BY_MEMBERID_RVCODE = 
			"select * from ${tbl_rvlike} "
			+ "where ${col_memberid} = #{memberid} and ${col_rvcode} = #{rvcode}";
	
	String SQL_RVLIKE_INSERT = 
			"insert into ${tbl_rvlike} "
			+ "( ${col_memberid}, ${col_rvcode} ) "
			+ "values ( #{memberid}, #{rvcode} )";
	
	@Update(SQL_RVLIKE_LIKE_CHECK)
	int updateLikecheck(@Param("memberid") String memberid, @Param("rvcode") int rvcode);
	
	@Update(SQL_RVLIKE_LIKE_CHECK_CANCEL)
	int updateLikecheckCancel(@Param("memberid") String memberid, @Param("rvcode") int rvcode);
	
	@Select(SQL_RVLIKE_SELECT_BY_MEMBERID_RVCODE)
	Rvlike selectByMemberidRvcode(@Param("memberid") String memberid, @Param("rvcode") int rvcode);
	
	@Insert(SQL_RVLIKE_INSERT)
	int insertRvlike(@Param("memberid") String memberid, @Param("rvcode") int rvcode);
	
} // end interface RvlikeMapper
