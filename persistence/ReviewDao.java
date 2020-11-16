package edu.spring.posco.persistence;


import java.util.List;
import java.util.Map;

import edu.spring.posco.domain.Review;

public interface ReviewDao {
	
	List<Review> reviewAll();
	Integer insertReview(Review review);
	int updateReview(Review review);
	int deleteReview(int rvcode);
	Review searchReview(int moviecd);
	Review searchReviewByRvcode(int rvcode);
	Integer updateRvrecomm(int rvcode, int increase);
	int updateRvreplycnt(int rvcode, int increase);

} // end interface ReviewDao
