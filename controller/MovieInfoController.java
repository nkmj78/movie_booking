package edu.spring.posco.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.xmlpull.v1.XmlPullParserException;

import edu.spring.posco.domain.MovieInfo;
import edu.spring.posco.service.MovieInfoService;

@Controller
public class MovieInfoController {
	@Autowired private MovieInfoService service;
	private List<MovieInfo> mList = new ArrayList<>();
	
	
	//@RequestMapping(value = "/movieList", method = RequestMethod.GET)
	@RequestMapping("movieList")
	public ModelAndView movieList(@RequestParam(required=false)String keyword, Model model) throws IOException, XmlPullParserException {
		System.out.println("movieList ...");
		ModelAndView mav= new ModelAndView();
		if(keyword != null) { 
					mav.addObject("movieList",service.searchMovie(keyword, 30, 1));
					mList = service.searchMovie(keyword, 30, 1);
				mav.addObject("movieList",service.searchMovie(keyword, 30, 1));
				mList = service.searchMovie(keyword, 30, 1);

		}
		
		mav.setViewName("movieList");
		model.addAttribute("keyword", keyword);
	
		
		
		return mav;
		
	}
	// 인증이 필요한 경우, 혹은 잘못된 인증
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Unauthorized")
	public class UnauthorizedException extends RuntimeException {
	
	  public UnauthorizedException(String message) {
	    super(message);
	  }
	}
}
