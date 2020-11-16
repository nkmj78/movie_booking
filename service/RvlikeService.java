package edu.spring.posco.service;

import edu.spring.posco.domain.Rvlike;

public interface RvlikeService {
	
	int updateLikecheck(String memberid, int rvcode);
	int updateLikecheckCancel(String memberid, int rvcode);
	Rvlike selectByMemberidRvcode(String memberid, int rvcode);
	int insertRvlike(String memberid, int rvcode);

} // end interface RvlikeService
