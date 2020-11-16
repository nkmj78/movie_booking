package edu.spring.posco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.Rvlike;
import edu.spring.posco.persistence.RvlikeDao;

@Service
public class RvlikeServiceImple implements RvlikeService {
	
	@Autowired RvlikeDao rvlikeDao;

	@Override
	public int updateLikecheck(String memberid, int rvcode) {
		
		return rvlikeDao.updateLikecheck(memberid, rvcode);
	} // end updateLikecheck()

	@Override
	public int updateLikecheckCancel(String memberid, int rvcode) {
		
		return rvlikeDao.updateLikecheckCancel(memberid, rvcode);
	} // end updateLikecheckCancel()

	@Override
	public Rvlike selectByMemberidRvcode(String memberid, int rvcode) {
		
		return rvlikeDao.selectByMemberidRvcode(memberid, rvcode);
	} // end selectByMemberidRvcode()

	@Override
	public int insertRvlike(String memberid, int rvcode) {
		
		return rvlikeDao.insertRvlike(memberid, rvcode);
	} // end insertRvlike()

} // end RvlikeServiceImple
