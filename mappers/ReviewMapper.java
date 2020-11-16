package edu.spring.posco.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.posco.domain.Review;

public interface ReviewMapper {
	
	String SQL_REVIEW_ALL =
			"select * from ${tbl_review} order by ${col_rvdate} desc ";
	
	String SQL_REVIEW_INSERT = 
			"insert into ${tbl_review} (${col_memberid}, ${col_rvtitle}, ${col_rvcontent}, ${col_movienm}, ${col_rvpoints}, ${col_moviecd})"
			+ " values ( #{memberid} , #{rvtitle} , #{rvcontent} , #{movienm}, #{rvpoints}, #{moviecd} )";
	      
	String SQL_REVIEW_UPDATE = 
			"update ${tbl_review} "
			+ "set ${col_rvtitle} = #{rvtitle}, ${col_rvcontent} = #{rvcontent}, ${col_rvpoints} = #{rvpoints}, ${col_rvdate} = sysdate  "
			+ "where ${col_rvcode} = #{rvcode}";
	
	String SQL_REVIEW_DELETE = 
			"delete from ${tbl_review} where ${col_rvcode} = #{rvcode}";
	
	String SQL_REVIEW_SEARCH = 
			"select * from ${tbl_review} "
			+ " where ${col_moviecd} = #{moviecd} ";
	
	String SQL_REVIEW_SEARCH_BY_RVCODE = 
			"select * from ${tbl_review} "
					+ " where ${col_rvcode} = #{rvcode} ";
	
	
	String SQL_REVIEW_RVRECOMMCNT = 
			"update ${tbl_review} " + "set ${col_rvrecommcnt} = ${col_rvrecommcnt} + #{increase} " 
			+ " where ${col_rvcode} = #{rvcode}"; 
	
	String SQL_REVIEW_RVREPLYCNT = 
			"update ${tbl_review} "
			+ "set ${col_rvreplycnt} = ${col_rvreplycnt} + #{increase} "
			+ "where ${col_rvcode} = #{rvcode}";
	

	
	@Select(SQL_REVIEW_ALL)
	List<Review> reviewAll ();
	
	@Insert(SQL_REVIEW_INSERT)
	Integer insertReview(Review review);
	
	@Update(SQL_REVIEW_UPDATE)
	int updateReview(Review review);
	
	@Delete(SQL_REVIEW_DELETE)
	int deleteReview(int rvcode);

	@Select(SQL_REVIEW_SEARCH)
	Review searchReview(int moviecd);
	
	@Select(SQL_REVIEW_SEARCH_BY_RVCODE)
	Review searchReviewByRvcode(int rvcode);
	
	@Select(SQL_REVIEW_RVRECOMMCNT)
	Integer updateRvrecomm(@Param("rvcode") int rvcode, @Param("increase")int increase);
		
	@Update(SQL_REVIEW_RVREPLYCNT)
	int updateRvreplycnt(@Param("rvcode") int rvcode, @Param("increase")int increase);


} // end interface ReviewMapper
