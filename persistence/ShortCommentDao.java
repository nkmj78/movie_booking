package edu.spring.posco.persistence;

import java.util.List;

import edu.spring.posco.domain.ShortComment;

public interface ShortCommentDao {

	List<ShortComment> stctAll (int moviecd);
	
	ShortComment stctselect (ShortComment shortcomment) ;
	
	int stctinsert (ShortComment shortComment);
		
	int stctdelete (int commcd);
	
}
