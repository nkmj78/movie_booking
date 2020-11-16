package edu.spring.posco.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.spring.posco.domain.BoxOffice;
import edu.spring.posco.mappers.BoxOfficeMapper;

public interface BoxDao {

	int boxList(BoxOffice box);
	int boxShift();
	List<BoxOffice> boxSelectAll();
}
