package edu.spring.posco.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.posco.domain.Member;
import edu.spring.posco.service.MemberService;

@Controller
public class SigninController {
	
	private Logger log = LoggerFactory.getLogger(SigninController.class);
	
	@Autowired MemberService memberService;
	
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public void signin (String target, Model model) {
		log.info("signin(target={}) GET 호출", target);
		
		if(target != null && !target.equals("")) {
			model.addAttribute("target", target);
		} // end if
		
	} // end signin() 
	
	

	@RequestMapping(value= "/signin", method=RequestMethod.POST)
	
	public void signin(Member member, Model model) {
		log.info("signin({})", member);
		
		Member signinMember = memberService.signin(member);
		log.info("signinMember: {}", signinMember);
		
		model.addAttribute("signinMember", signinMember);
		
	} // end signin()
	
	@RequestMapping(value="/signout", method=RequestMethod.GET)
	public String signOut(HttpSession session, HttpServletResponse
			response) throws IOException {
		
		log.info("signOut(");
		
		session.removeAttribute("signinId");
		session.invalidate();
		
		// 로그아웃 되었다고 알려주기
		
		return "redirect:/";
	} // end signOut()
	
} // end class SigninController
