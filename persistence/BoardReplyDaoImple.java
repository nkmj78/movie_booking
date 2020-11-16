package edu.spring.posco.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.BoardReply;
import edu.spring.posco.domain.Rvreply;
import edu.spring.posco.mappers.BoardReplyMapper;
import edu.spring.posco.service.BoardReplyServiceImple;

@Repository
public class BoardReplyDaoImple implements BoardReplyDao {
	
	@Autowired BoardReplyMapper mapper;

	
	private static final Logger log = LoggerFactory.getLogger(BoardReplyServiceImple.class);
	@Override
	
	
	public List<BoardReply> boardReplyAll() {
		log.info("보드리플라이 다오임플");
		
		return mapper.boardReplyAll() ;
	}

	@Override
	public int insertBoardReply(BoardReply boardReply) {
		log.info("보드리플라이 다오임플");
		return mapper.insertBoardReply(boardReply);
	}

	@Override
	public int updateBoardReply(BoardReply boardReply) {
		log.info("보드리플라이 다오임플");
		return mapper.updateBoardReply(boardReply);
	}
	
	@Override
	public int deleteBoardReply(int boardreplycd) {
		log.info("보드리플라이 다오임플");
		return mapper.deleteBoardReply(boardreplycd);
	}

	@Override
	public List<BoardReply> searchBoardReply(int bno) {
		log.info("보드리플라이 다오임플");
		return mapper.searchBoardReply(bno);
	}
	
	@Override
	public BoardReply selectboardreply(int boardreplycd) {
		// TODO Auto-generated method stub
		return mapper.selectboardreply(boardreplycd);
	}
	
	@Override
	public Integer readBoardreplycd(int boardreplycd) {
		// TODO Auto-generated method stub
		return mapper.readBoardReplycd(boardreplycd);
	}

	@Override
	public Integer deleteBoardReplyByBno(int bno) {
		// TODO Auto-generated method stub
		return mapper.deleteBoardReplyByBno(bno);
	}

}
