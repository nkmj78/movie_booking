package edu.spring.posco.persistence;

import edu.spring.posco.domain.Member;

public interface MemberDao {
	
	Member signup(Member member);
	Member signin(Member member);
	Member update(Member member);
	Member delete(Member member);
	Member signcheck (String memberid);
}
