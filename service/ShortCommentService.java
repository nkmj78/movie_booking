package edu.spring.posco.service;

import java.util.List;

import edu.spring.posco.domain.ShortComment;

public interface ShortCommentService {

	List<ShortComment> stctAll(int moviecd);
	
	ShortComment stctselect (ShortComment shortComment);
	
	int stctinsert (ShortComment shortComment);
	
	int stctdelete (int commcd);
}
