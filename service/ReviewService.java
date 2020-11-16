package edu.spring.posco.service;


import java.util.List;
import java.util.Map;

import edu.spring.posco.domain.Review;


public interface ReviewService {
	
	List<Review> reviewAll();
	int insertReview(Review review);
	int updateReview(Review review);
	int deleteReview(int rvcode);
	Review searchReview(int moviecd);
	Review searchReviewByRvcode(int rvcode);
	Integer updateRvrecomm(int rvcode, int increase);
	
} // end interface ReviewService
