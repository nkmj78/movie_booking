package edu.spring.posco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.FreeBoard;
import edu.spring.posco.persistence.FreeBoardDao;

@Service
public class FreeBoardServcieImple implements FreeBoardService {

	@Autowired FreeBoardDao freeBoardDao;
	
	@Override
	public List<FreeBoard> boardAll() {
		// TODO Auto-generated method stub
		return freeBoardDao.boardAll();
	}

	@Override
	public int insertBoard(FreeBoard freeBoard) {
		// TODO Auto-generated method stub
		return freeBoardDao.insertBoard(freeBoard);
	}

	@Override
	public int updateBoard(FreeBoard freeBoard) {
		// TODO Auto-generated method stub
		return freeBoardDao.updateBoard(freeBoard);
	}

	@Override
	public int deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return freeBoardDao.deleteBoard(bno);
	}

	@Override
	public FreeBoard searchBoard(int bno) {
		// TODO Auto-generated method stub
		return freeBoardDao.searchBoard(bno);
	}

}
