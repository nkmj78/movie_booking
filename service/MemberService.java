package edu.spring.posco.service;

import edu.spring.posco.domain.Member;

public interface MemberService {
	Member signup(Member member);
	
	Member signin(Member member);
	
	Member update(Member member);
	
	Member delete(Member member);
	
	Member signcheck(String memberid);
} // end interface MemberService
