package edu.spring.posco.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.Rvlike;
import edu.spring.posco.mappers.RvlikeMapper;

@Repository
public class RvlikeDaoImple implements RvlikeDao {
	
	@Autowired RvlikeMapper mapper;

	@Override
	public int updateLikecheck(String memberid, int rvcode) {
		
		return mapper.updateLikecheck(memberid, rvcode);
	} // end updateLikecheck()

	@Override
	public int updateLikecheckCancel(String memberid, int rvcode) {
		
		return mapper.updateLikecheckCancel(memberid, rvcode);
	} // end updateLikecheckCancel()

	@Override
	public Rvlike selectByMemberidRvcode(String memberid, int rvcode) {
		
		return mapper.selectByMemberidRvcode(memberid, rvcode);
	} // end selectByMemberidRvcode()

	@Override
	public int insertRvlike(String memberid, int rvcode) {
		
		return mapper.insertRvlike(memberid, rvcode);
	} // end insertRvlike()

} // end RvlikeDaoImple
