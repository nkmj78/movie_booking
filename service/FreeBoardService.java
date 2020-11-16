package edu.spring.posco.service;

import java.util.List;

import edu.spring.posco.domain.FreeBoard;

public interface FreeBoardService {
	
	List<FreeBoard> boardAll();
	int insertBoard(FreeBoard freeBoard);
	int updateBoard(FreeBoard freeBoard);
	int deleteBoard(int bno);
	FreeBoard searchBoard(int bno);
}
