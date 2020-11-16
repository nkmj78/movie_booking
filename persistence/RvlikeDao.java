package edu.spring.posco.persistence;

import edu.spring.posco.domain.Rvlike;

public interface RvlikeDao {
	
	int updateLikecheck(String memberid, int rvcode);
	int updateLikecheckCancel(String memberid, int rvcode);
	Rvlike selectByMemberidRvcode(String memberid, int rvcode);
	int insertRvlike(String memberid, int rvcode);
	
} // end interface RvlikeDao
