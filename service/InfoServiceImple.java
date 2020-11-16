package edu.spring.posco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.MovieInfo;
import edu.spring.posco.domain.Review;
import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.persistence.InfoDao;

@Service
public class InfoServiceImple implements InfoService {
	
	@Autowired InfoDao infoDao;


	@Override
	public List<Review> movieReviewsSelctAll(String movieCd) {
		return infoDao.movieReviewsSelectAll(movieCd);
	}
	
	

}
