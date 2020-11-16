package edu.spring.posco.persistence;

import java.util.List;

import edu.spring.posco.domain.BoardReply;
import edu.spring.posco.domain.Rvreply;

public interface BoardReplyDao {
	
	List<BoardReply> boardReplyAll();
	int insertBoardReply(BoardReply boardReply);
	int updateBoardReply(BoardReply boardReply);
	int deleteBoardReply(int boardreplycd);
	List<BoardReply> searchBoardReply(int bno);
	BoardReply selectboardreply(int boardreplycd);
	Integer readBoardreplycd(int boardreplycd);
	Integer deleteBoardReplyByBno(int bno);
}
