package edu.spring.posco.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import edu.spring.posco.domain.Review;
import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.mappers.InfoMapper;

@Repository
public class InfoDaoImple implements InfoDao {
	
	@Autowired private InfoMapper mapper;
	
	@Override
	public List<Review> movieReviewsSelectAll(String movieCd) {
		return mapper.movieReviewsSelectAll(movieCd);
	}

	
	
	
}
