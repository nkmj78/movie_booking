package edu.spring.posco.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.persistence.ReviewDao;
import edu.spring.posco.persistence.RvreplyDao;
import edu.spring.posco.service.RvreplyService;

@RestController
@RequestMapping(value="/rvreplies")
public class RvreplyController {
	private static final Logger log = LoggerFactory.getLogger(RvreplyController.class);
	
	@Autowired RvreplyService rvreplyService;
	@Autowired RvreplyDao rvreplyDao;
	@Autowired ReviewDao reviewDao;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Integer> createRvreply(@RequestBody Rvreply rvreply) {
		
		log.info("insertRvreply() 호출", rvreply);
		
		int result = rvreplyService.insertRvreply(rvreply);
		
		ResponseEntity<Integer> entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		return entity;
	} // end insertRvreply()
	
	@RequestMapping(value="/all/{rvcode}", method=RequestMethod.GET) 
	public ResponseEntity<List<Rvreply>> readRvreply(@PathVariable(name="rvcode") Integer rvcode) {
		log.info("searchRvreply(rvcode={})", rvcode);
		
		List<Rvreply> list = rvreplyService.searchRvreply(rvcode);
		
		ResponseEntity<List<Rvreply>> entity = new ResponseEntity<List<Rvreply>>(list, HttpStatus.OK);
		
		return entity;
	} // end searchRvreply()
	
	@RequestMapping(value="/{rvreplycd}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateRvreply (@PathVariable(name="rvreplycd") Integer rvreplycd, @RequestBody Rvreply rvreply){
		log.info("updateReply(rvreplycd={}, {})", rvreplycd, rvreply);
		rvreply.setRvreplycd(rvreplycd);
		int result = rvreplyService.updateRvreply(rvreply);
		String res="";
		if(result == 1) { // 성공
			res = "s";
		} else { // 실패
			res="f";
		}
		ResponseEntity<String> entity = new ResponseEntity<String>(res, HttpStatus.OK);
		
		return entity;
		 
	} // end updateRvreply()
	
	@RequestMapping(value="/{rvreplycd}", method=RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteReply (@PathVariable(name="rvreplycd") Integer rvreplycd) {
		log.info("deleteRvreply(rvreply={})", rvreplycd);

		int result = rvreplyService.deleteRvreply(rvreplycd);
	
		
		ResponseEntity<Integer> entity = new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		return entity;
		
		
	} // end deleteRvreply()

} // end class RvreplyController
