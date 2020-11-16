package edu.spring.posco.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.spring.posco.domain.Member;

// signin post 방식 콘트롤러 메소드를 가로채서 
// 로그인 성공 -> target 으로 redirect
// 로그인 실패 -> signin 요청을 get 방식으로 redirect
public class SignInInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(SignInInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(request.getMethod().equals("GET")) {
			return; // GET 방식은 처리하지 않음
		}
		
		log.info("postHandle() 호출"); 
				 
		Object member = modelAndView.getModel().get("signinMember");
		
		if(member != null) { // 로그인 성공한 경우
			log.info("로그인 성공");
			// 세션에 로그인 정보(사용자 아이디)를 저장하고, 페이지 이동(redirect)
			HttpSession session = request.getSession();
			session.setAttribute("signinId", ((Member)member).getMemberid());
			
			// 로그인 버튼 누른 이전 페이지로 다시 띄워주기 위함
			String referer = request.getHeader("Referer");
			session.setAttribute("redirectURI", referer);
			log.info("referer: " + referer);
			
			log.info("로그인 성공!!!!!!!!!!!!!!!1");
			response.sendRedirect(referer);
			
		} else {	// 로그인 실패한 경우
			log.info("로그인 실패");
			
			// 다시 로그인 페이지로 이동(redirect)
			response.sendRedirect("/posco/");
		}
			
	} // end postHandle()

} // end class SignInInterceptor
