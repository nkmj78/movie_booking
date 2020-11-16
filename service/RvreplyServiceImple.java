package edu.spring.posco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.persistence.ReviewDao;
import edu.spring.posco.persistence.RvreplyDao;

@Service
public class RvreplyServiceImple implements RvreplyService {
	
	@Autowired private RvreplyDao rvreplyDao;
	@Autowired private ReviewDao reviewDao;

	@Override
	public int insertRvreply(Rvreply rvreply) {
		
		int result = rvreplyDao.insertRvreply(rvreply);
		
		result = reviewDao.updateRvreplycnt(rvreply.getRvcode(), 1);
		
		return result; 
	} // end insertRvreply()

	@Override
	public int updateRvreply(Rvreply rvreply) {
		return rvreplyDao.updateRvreply(rvreply);
	} // end updateRvreply()

	@Override
	public int deleteRvreply(int rvreplycd) {
		
		Integer rvcode = rvreplyDao.readRvreplycd(rvreplycd);
		
		int result = rvreplyDao.deleteRvreply(rvreplycd);
		
		result = reviewDao.updateRvreplycnt(rvcode, -1);
		
		
		return result;
	} // end deleteRvreply()

	@Override
	public List<Rvreply> searchRvreply(int rvcode) {
		return rvreplyDao.searchRvreply(rvcode);
	} // end searchRvreply()	

	@Override
	public Integer deleteRvreplyByRvcode(int rvcode) {
		
		return rvreplyDao.deleteRvreplyByRvcode(rvcode);
	} // end deleteRvreplyByRvcode()

	

} // end class RvreplyServiceImple
