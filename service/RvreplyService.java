package edu.spring.posco.service;

import java.util.List;

import edu.spring.posco.domain.Rvreply;

public interface RvreplyService {
	
	int insertRvreply(Rvreply rvreply);
	int updateRvreply(Rvreply rvreply);
	int deleteRvreply(int rvvreplycd);
	List<Rvreply> searchRvreply(int rvcode);
	Integer deleteRvreplyByRvcode(int rvcode);
} // end interface RvreplyService
