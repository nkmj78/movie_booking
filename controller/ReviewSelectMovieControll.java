package edu.spring.posco.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xmlpull.v1.XmlPullParserException;

import edu.spring.posco.domain.MovieInfo;
import edu.spring.posco.service.MovieInfoService;

@Controller
public class ReviewSelectMovieControll {
	@Autowired private MovieInfoService service;
	private List<MovieInfo> mList = new ArrayList<>();
	
	
	//@RequestMapping(value = "/movieList", method = RequestMethod.GET)
	@RequestMapping("reviewSelectMovie")
	public ModelAndView movieList(@RequestParam(required=false)String keyword, Model model) throws IOException, XmlPullParserException {
		System.out.println("reviewSelectMovie ...");
		ModelAndView mav= new ModelAndView();
		if(keyword != null) { 
					mav.addObject("reviewSelectMovie",service.searchMovie(keyword, 30, 1));
					mList = service.searchMovie(keyword, 30, 1);
				mav.addObject("reviewSelectMovie",service.searchMovie(keyword, 30, 1));
				mList = service.searchMovie(keyword, 30, 1);
		}
		mav.setViewName("reviewSelectMovie");
		model.addAttribute("keyword", keyword);

		return mav;
		
	}
}
