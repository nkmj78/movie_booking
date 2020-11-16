package edu.spring.posco.persistence;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.Member;
import edu.spring.posco.mappers.MemberMapper;
import edu.spring.posco.service.MemberService;

@Repository
public class MemberDaoImple implements MemberDao {

	@Autowired private MemberMapper mapper;
	@Autowired SqlSession sqlsession;
	
	@Override
	public Member signup(Member member) {
		
		return mapper.signup(member);
	}
	
	@Override
	public Member signin(Member member) {
		
		return mapper.signin(member);
	}
	
	@Override
	public Member update(Member member) {
	
		return mapper.update(member);
	}
	
	@Override
	public Member delete(Member member) {
		// TODO Auto-generated method stub
		return mapper.delete(member);
	}

	@Override
	public Member signcheck(String memberid) {
		
		Member result = mapper.signcheck(memberid);
		
		return result;
	}

}
