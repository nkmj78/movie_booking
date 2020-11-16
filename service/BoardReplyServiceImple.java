package edu.spring.posco.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.BoardReply;
import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.persistence.BoardReplyDao;
import edu.spring.posco.persistence.FreeBoardDao;


@Service
public class BoardReplyServiceImple implements BoardReplyService {
	
	@Autowired BoardReplyDao dao;
	@Autowired FreeBoardDao dao1;

	private static final Logger log = LoggerFactory.getLogger(BoardReplyServiceImple.class);
	@Override
	public List<BoardReply> boardReplyAll() {
		log.info("service reply boardReplyAll ");
		return dao.boardReplyAll();
	}

	@Override
	public int insertBoardReply(BoardReply boardReply) {
		// TODO Auto-generated method stub
		log.info("service reply boardReplyAll ");
		
		int result = dao.insertBoardReply(boardReply);
		
		result = dao1.updateReplyCnt(boardReply.getBno(), 1);
		
		return result; 
	}

	@Override
	public int updateBoardReply(BoardReply boardReply) {
		// TODO Auto-generated method stub
		log.info("service reply boardReplyAll ");

		return dao.updateBoardReply(boardReply);
	}

	@Override
	public int deleteBoardReply(int boardreplycd) {
		
		Integer bno = dao.readBoardreplycd(boardreplycd);
		
		int result = dao.deleteBoardReply(boardreplycd);
		
		result = dao1.updateReplyCnt(bno, -1);
		
		
		return result;
	}

	@Override
	public List<BoardReply> searchBoardReply(int bno) {
		log.info("service reply boardReplyAll ");

		// TODO Auto-generated method stub
		return dao.searchBoardReply(bno);
	}

	@Override
	public Integer deleteBoardReplyByBno(int bno) {
		// TODO Auto-generated method stub
		return dao.deleteBoardReplyByBno(bno);
	}

}
