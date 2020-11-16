package edu.spring.posco.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xmlpull.v1.XmlPullParserException;

import edu.spring.posco.service.InfoService;

@RestController
public class InfoDBController {
	private static String clientID="WWJKK8nYSknY1spU7Rnj";
	private static String clientSecret="lBAgYKP7GS";
	@Autowired InfoService infoservice;
	@RequestMapping(value="/infopage", method=RequestMethod.GET)
	public ResponseEntity<String> readAllmovie(HttpServletResponse response)
			throws XmlPullParserException, IOException{
		//url 주소
		String Url="https://openapi.naver.com/v1/search/movie.json"
				+"?key";

				return null;
	}
}
