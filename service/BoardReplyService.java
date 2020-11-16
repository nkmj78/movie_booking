package edu.spring.posco.service;

import java.util.List;

import edu.spring.posco.domain.BoardReply;
import edu.spring.posco.domain.Rvreply;

public interface BoardReplyService {
	
	List<BoardReply> boardReplyAll();
	int insertBoardReply(BoardReply boardReply);
	int updateBoardReply(BoardReply boardReply);
	int deleteBoardReply(int boardreplycd);
	List<BoardReply> searchBoardReply(int bno);
	Integer deleteBoardReplyByBno(int bno);
}
