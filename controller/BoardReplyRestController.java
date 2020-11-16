package edu.spring.posco.controller;

import java.util.List;

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

import edu.spring.posco.domain.BoardReply;
import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.persistence.BoardReplyDao;
import edu.spring.posco.service.BoardReplyService;

@RestController
@RequestMapping(value = "/freeboardreplies")

public class BoardReplyRestController {
	
	@Autowired BoardReplyService boardReplyService;
	@Autowired BoardReplyDao dao;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Integer> createReply(
			@RequestBody BoardReply boardReply) {
		// @RequestBody: 클라이언트(브라우저)에서 보내는 데이터가 요청 패킷 본문(body)에 
		// 포함되어 있음을 알려주는 어노테이션
		// 요청 시 보내는 데이터가 질의 문자열에 있지 않고, form-data도 아닌 경우에 사용
		
		int result = boardReplyService.insertBoardReply(boardReply);
		
		ResponseEntity<Integer> entity = 
				new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		return entity;
	} // end createReply()
	private static final Logger log = LoggerFactory.getLogger(BoardReplyRestController.class);
	@RequestMapping(value = "/all/{bno}", method = RequestMethod.GET)
	public ResponseEntity<List<BoardReply>> readAllReplies(
			@PathVariable(name = "bno") Integer bno) {
		
		List<BoardReply> list = boardReplyService.searchBoardReply(bno);
		
		ResponseEntity<List<BoardReply>> entity = 
				new ResponseEntity<List<BoardReply>>(list, HttpStatus.OK);
		log.info("BoardReplyRestController");
		return entity;
	} // end readAllReplies()
	
	@RequestMapping(value = "/{boardreplycd}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateReply(
			@PathVariable(name = "boardreplycd") Integer boardreplycd,
			@RequestBody BoardReply boardReply) {
		boardReply.setBoardreplycd(boardreplycd);
		int result = boardReplyService.updateBoardReply(boardReply);
		String res = "";
		if (result == 1) {
			res = "s"; // 성공(success)
		} else {
			res = "f"; // 실패(fail)  
		}
		
		ResponseEntity<String> entity = 
				new ResponseEntity<String>(res, HttpStatus.OK);
		
		return entity;
	} // end updateReply()

	@RequestMapping(value = "/{boardreplycd}", method = RequestMethod.DELETE)
	public ResponseEntity<Integer> deleteReply(
			@PathVariable(name = "boardreplycd") Integer boardreplycd) {
		
		int result = boardReplyService.deleteBoardReply(boardreplycd);
		
		BoardReply boardReply = dao.selectboardreply(boardreplycd);
		
		ResponseEntity<Integer> entity = 
				new ResponseEntity<Integer>(result, HttpStatus.OK);
		
		return entity;
	} // end deleteReply()

}
