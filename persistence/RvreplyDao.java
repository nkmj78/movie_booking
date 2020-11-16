package edu.spring.posco.persistence;

import java.util.List;

import edu.spring.posco.domain.Rvreply;

public interface RvreplyDao {
	
	int insertRvreply(Rvreply rvreply);
	int updateRvreply(Rvreply rvreply);
	int deleteRvreply(int rvreplycd);
	List<Rvreply> searchRvreply(int rvcode);
	Rvreply selectRvreply(int rvreplycd);
	Integer readRvreplycd(int rvreplycd);
	Integer deleteRvreplyByRvcode(int rvcode);
} // end interface RvreplyDao
