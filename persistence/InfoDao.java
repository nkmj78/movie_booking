package edu.spring.posco.persistence;

import java.util.List;


import edu.spring.posco.domain.Review;
import edu.spring.posco.domain.Rvreply;

public interface InfoDao {
	
	
	List<Review> movieReviewsSelectAll(String movieCd);
	
	
	
	
}
