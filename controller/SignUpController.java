package edu.spring.posco.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.AlternativeJdkIdGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.spring.posco.domain.Member;
import edu.spring.posco.service.MemberService;

@Controller
public class SignUpController {
	@Autowired MemberService memberService;
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SignUpController.class);
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String poscoMain(Member member) {
		logger.info("boardMain() 호출");
		
		// 가입하는 기능
		// DB  insert  

		memberService.signup(member);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void signup() {
		
	}
	
	
	@RequestMapping(value = {"/signcheck", "/board/signcheck"}, method = RequestMethod.POST)
	@ResponseBody
	public Member idCheck (HttpServletRequest request) {
		
		
		logger.info("들어왔나유");
		String memberid = request.getParameter("memberid");
		Member result = memberService.signcheck(memberid);
		
		return result;
	}
	
	

} // end class SignupController
