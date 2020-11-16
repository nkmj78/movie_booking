package edu.spring.posco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.spring.posco.domain.Payment;
import edu.spring.posco.domain.Reservation;
import edu.spring.posco.service.ReservService;

@Controller
public class ReservationCotrollor {
	private Logger log= LoggerFactory.getLogger(ReservationCotrollor.class);
	
	@Autowired ReservService reservService;
	
	@RequestMapping(value="/reservation", method=RequestMethod.GET)
	public void ReservationView(Reservation reserv) {
		
	}
	
	@RequestMapping(value="/payment", method=RequestMethod.GET)
	public String GoToPayment(
			 String nowTitle
			,String nowTheater
			,String nowCal
			,String nowTime
			,String nowPay
			, Model model) {
		log.info("여기까지 들어왔을까요?");
		System.out.println("일루와라라라라");
		
		model.addAttribute("movietitle",nowTitle);
		model.addAttribute("reserv_theater",nowTheater);
		model.addAttribute("reserv_date",nowCal);
		model.addAttribute("reserv_time",nowTime);
		model.addAttribute("paytype",nowPay);
		log.info(nowTitle +"영화 제목이 들어왔을까");
		return "payment";
	}
	
}


