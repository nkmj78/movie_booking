package edu.spring.posco.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.Review;
import edu.spring.posco.persistence.ReviewDao;

@Service
public class ReviewServiceImple implements ReviewService {
	
	@Autowired ReviewDao reviewDao;

	@Override
	public int insertReview(Review review) {
		
		return reviewDao.insertReview(review);
	} // end insertReview()

	@Override
	public List<Review> reviewAll() {
		
		return reviewDao.reviewAll();
	} // end reviewAll()

	@Override
	public int updateReview(Review review) {
		
		return reviewDao.updateReview(review);
	} // end updateReview()

	@Override
	public int deleteReview(int rvcode) {
		
		return reviewDao.deleteReview(rvcode);
	} // end deleteReview()

	@Override
	public Review searchReview(int moviecd) {
		
		return reviewDao.searchReview(moviecd);
	} // end searchReview()
	

	@Override
	public Review searchReviewByRvcode(int rvcode) {
		
		return reviewDao.searchReviewByRvcode(rvcode);
	} // end searchReviewByRvcode()

	@Override
	public Integer updateRvrecomm(int rvcode, int increase) {
		
		return reviewDao.updateRvrecomm(rvcode, increase);
	} // end updateRvrecomm()

	
} // end class ReviewServiceImple
