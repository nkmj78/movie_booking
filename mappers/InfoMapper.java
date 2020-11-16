package edu.spring.posco.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;


import edu.spring.posco.domain.Review;
import edu.spring.posco.domain.Rvreply;

public interface InfoMapper {
	
	String SQL_MOVIEINFO_REVIEW_SELECTALL = "select rvtitle, rvcontent, memberid, movienm, rvdate, rvreplycnt, rvrecommcnt, rvcode, rvpoints from review"
			+ " where moviecd=#{moviecd}";
	@Select(SQL_MOVIEINFO_REVIEW_SELECTALL)
	List<Review> movieReviewsSelectAll(String movieCd);
	
	
	
	
	
	
}
