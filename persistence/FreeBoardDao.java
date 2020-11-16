package edu.spring.posco.persistence;

import java.util.List;

import edu.spring.posco.domain.FreeBoard;

public interface FreeBoardDao {
	
	List<FreeBoard> boardAll();
	Integer insertBoard(FreeBoard freeBoard);
	int updateBoard(FreeBoard freeBoard);
	int deleteBoard(int bno);
	FreeBoard searchBoard(int bno);
	int updateReplyCnt(int bno, int increase);
}
