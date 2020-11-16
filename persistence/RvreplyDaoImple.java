package edu.spring.posco.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.mappers.RvReplyMapper;


@Repository
public class RvreplyDaoImple implements RvreplyDao {
	
	@Autowired RvReplyMapper mapper;

	@Override
	public int insertRvreply(Rvreply rvreply) {
		
		return mapper.insertRvreply(rvreply);
	} // end insertRvreply()

	@Override
	public int updateRvreply(Rvreply rvreply) {
	
		return mapper.updateRvreply(rvreply);
	} // end updateRvreply()

	@Override
	public int deleteRvreply(int rvreplycd) {
		
		return mapper.deleteRvreply(rvreplycd);
	} // end deleteRvreply()

	@Override
	public List<Rvreply> searchRvreply(int rvcode) {
		
		return mapper.searchRvreply(rvcode);
	} // end searchRvreply()

	@Override
	public Rvreply selectRvreply(int rvreplycd) {
		
		return mapper.selectRvreply(rvreplycd);
	} // end selectRvreply()

	@Override
	public Integer readRvreplycd(int rvreplycd) {
		
		return mapper.readRvreplycd(rvreplycd);
	} // end readRvreplycd()

	@Override
	public Integer deleteRvreplyByRvcode(int rvcode) {
		
		return mapper.deleteRvreplyByRvcode(rvcode);
	} // end deleteRvreplyByRvcode()

	
} // end class RvreplyDaoImple
