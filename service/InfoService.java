package edu.spring.posco.service;

import java.util.List;

import edu.spring.posco.domain.MovieInfo;
import edu.spring.posco.domain.Review;
import edu.spring.posco.domain.Rvreply;

public interface InfoService {
	
	
	List<Review> movieReviewsSelctAll(String movieCd);
	
	
	
	
}
