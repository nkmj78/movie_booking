package edu.spring.posco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.spring.posco.service.BoxService;

@Controller
public class MainController {
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired BoxService boxservice;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String poscoMain(Model model) {
		logger.info("boardMain() 호출");
		
		model.addAttribute("box",boxservice.boxSelectAll());
		return "main";
	}
		
} // end mainController
 