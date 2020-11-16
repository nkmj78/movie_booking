package edu.spring.posco.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.BoxOffice;
import edu.spring.posco.mappers.BoxOfficeMapper;

@Repository
public class BoxDaoImple implements BoxDao {
	@Autowired private BoxOfficeMapper mapper; 

	@Override
	public int boxList(BoxOffice box) {
		System.out.println(box);
		return mapper.boxList(box);
	}

	@Override
	public int boxShift() {
	
		return mapper.boxShift();
	}
	
	@Override
	public List<BoxOffice> boxSelectAll() {
		
		return mapper.boxSelectAll();
	}

}
