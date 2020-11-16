package edu.spring.posco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.posco.domain.ShortComment;
import edu.spring.posco.persistence.ShortCommentDao;

@Service
public class ShortCommentServiceImple implements ShortCommentService {

	@Autowired ShortCommentDao shortcommentDao;
	
	@Override
	public List<ShortComment> stctAll(int moviecd) {
		// TODO Auto-generated method stub
		return shortcommentDao.stctAll(moviecd) ; 
	} // end stctAll()

	@Override
	public ShortComment stctselect(ShortComment shortComment) {
		// TODO Auto-generated method stub
		return shortcommentDao.stctselect(shortComment);
	} // end stctselect()
	
	@Override
	public int stctinsert(ShortComment shortComment) {
		// TODO Auto-generated method stub
		return shortcommentDao.stctinsert(shortComment);
	} // end stctinsert()


	@Override
	public int stctdelete(int commcd) {
		// TODO Auto-generated method stub
		return shortcommentDao.stctdelete(commcd);
	} // end stctdelete()


} // end class ShortCommentServiceImple
