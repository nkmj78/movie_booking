package edu.spring.posco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.BoxOffice;
import edu.spring.posco.persistence.BoxDao;

@Service
public class BoxServiceImple implements BoxService {
	
	@Autowired BoxDao boxDao;
	
	@Override
	public int boxList(BoxOffice box) {
		
		return boxDao.boxList(box);
	}

	@Override
	public int boxShift() {
		
		return boxDao.boxShift();
	}
	
	@Override
	public List<BoxOffice> boxSelectAll() {
		
		return boxDao.boxSelectAll();
	}

}
