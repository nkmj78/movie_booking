package edu.spring.posco.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.posco.domain.ShortComment;
import edu.spring.posco.mappers.ShortCommentMapper;

@Repository
public class ShortCommentDaoImple implements ShortCommentDao {

	@Autowired ShortCommentMapper mapper;
	
	@Override
	public List<ShortComment> stctAll(int moviecd) {
		
		return mapper.stctAll(moviecd);
	} // end stctAll()
	
	@Override
	public ShortComment stctselect(ShortComment shortComment) {
		
		return mapper.stctselect(shortComment);
	} // end stctselect()

	@Override
	public int stctinsert(ShortComment shortComment) {
		
		return mapper.stctinsert(shortComment);
	} // end stctinsert()

	@Override
	public int stctdelete(int commcd) {
	
		return mapper.stctdelete(commcd);
	} // end stctdelete()

	

	
}
