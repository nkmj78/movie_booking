package edu.spring.posco.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.Review;
import edu.spring.posco.mappers.ReviewMapper;

@Repository
public class ReviewDaoImple implements ReviewDao {

	@Autowired ReviewMapper mapper;

	@Override
	public Integer insertReview(Review review) {
		
		return mapper.insertReview(review);
	} // end insertReview()

	@Override
	public List<Review> reviewAll() {
		
		return mapper.reviewAll();
	} // end reviewAll()

	@Override
	public int updateReview(Review review) {
		
		return mapper.updateReview(review);
	} // end updateReview()

	@Override
	public int deleteReview(int rvcode) {
		
		return mapper.deleteReview(rvcode);
	} // end deleteReview()

	@Override
	public Review searchReview(int moviecd) {
		
		return mapper.searchReview(moviecd);
	} // end searchReview()


	@Override
	public Review searchReviewByRvcode(int rvcode) {
		
		return mapper.searchReviewByRvcode(rvcode);
	} // end searchReviewByRvcode()



	@Override
	public int updateRvreplycnt(int rvcode, int increase){
		
		Map<String, Object> params = new HashMap<>();
		params.put("rvcode", rvcode);
		params.put("increase", increase);
		
		return mapper.updateRvreplycnt(rvcode, increase);
	} // end updateRvreplycntAdjust()

	@Override
	public Integer updateRvrecomm(int rvcode, int increase) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("rvcode", rvcode);
		params.put("increase", increase);
		
		return mapper.updateRvrecomm(rvcode, increase);
	} // end updateRvrecomm()

	
} // end class ReviewDaoImple
