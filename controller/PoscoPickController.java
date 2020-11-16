package edu.spring.posco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PoscoPickController {
	
	@RequestMapping(value = "/poscopick", method = RequestMethod.GET)
	public void goPickPage() {
		
		
	}
}
