package edu.spring.posco.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.Member;
import edu.spring.posco.persistence.MemberDao;


@Service
public class MemberServiceImple implements MemberService {
	private static final Logger log =
			LoggerFactory.getLogger(MemberServiceImple.class);
	
	@Autowired private MemberDao memberDao;
	
	@Override
	public Member signup(Member member) {
	log.info("signup({})", member);
		
		return memberDao.signup(member);
	}
	
	@Override
	public Member signin(Member member) {
		
		return memberDao.signin(member);
	}
	
	@Override
	public Member update(Member member) {
	
		return memberDao.update(member);
	}
	
	@Override
	public Member delete(Member member) {
		
		return memberDao.delete(member);
	}

	@Override
	public Member signcheck(String memberId) {
		
		Member result = memberDao.signcheck(memberId);
		
		return result;
	}
}
