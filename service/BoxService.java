package edu.spring.posco.service;

import java.util.List;

import edu.spring.posco.domain.BoxOffice;

public interface BoxService {
	
	int boxList(BoxOffice box);
	int boxShift();
	List<BoxOffice> boxSelectAll();
}
