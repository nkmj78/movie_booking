package edu.spring.posco.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.FreeBoard;
import edu.spring.posco.mappers.FreeBoardMapper;

@Repository
public class FreeBoardDaoImple implements FreeBoardDao {
	
	@Autowired FreeBoardMapper mapper;
	
	@Override
	public List<FreeBoard> boardAll() {
		// TODO Auto-generated method stub
		return mapper.boardAll();
	}

	@Override
	public Integer insertBoard(FreeBoard freeBoard) {
		// TODO Auto-generated method stub
		return mapper.insertBoard(freeBoard);
	}

	@Override
	public int updateBoard(FreeBoard freeBoard) {
		// TODO Auto-generated method stub
		return mapper.updateBoard(freeBoard);
	}

	@Override
	public int deleteBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.deleteBoard(bno);
	}

	@Override
	public FreeBoard searchBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.searchBoard(bno);
	}

	@Override
	public int updateReplyCnt(int bno, int increase) {
		
		Map<String, Object> params = new HashMap<>();
		params.put("bno", bno);
		params.put("increase", increase);
		
		return mapper.updateReplyCnt(bno, increase);
	}
}
