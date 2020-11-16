package edu.spring.posco.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.posco.domain.ShortComment;

public interface ShortCommentMapper {

	String SQL_SHORTCOMMENT_ALL =
			"select * from ${tbl_shortcomment} where ${col_moviecd} = #{moviecd}";
	
	String SQL_SHORTCOMMENT_SELECT =
			"select * from ${tbl_shortcomment}"
					+ " where ${col_moviecd} = #{moviecd} ";
	
	String SQL_SHORTCOMMENT_INSERT =
			"insert into ${tbl_shortcomment} (${col_moviecd}, ${col_memberid}, ${col_commcontent}) values " +
		"( #{moviecd}, #{memberid}, #{commcontent})";
	
	String SQL_SHORTCOMMENT_DELETE =
			"delete from ${tbl_shortcomment} "
			+ "where ${col_commcd} = #{commcd}";
	
	
	
	
	@Select(SQL_SHORTCOMMENT_ALL)
	List<ShortComment> stctAll(int moviecd);
	
	@Select(SQL_SHORTCOMMENT_SELECT)
	ShortComment stctselect (ShortComment shortComment);
	
	@Insert(SQL_SHORTCOMMENT_INSERT)
	int stctinsert (ShortComment shortComment);
	
	@Delete(SQL_SHORTCOMMENT_DELETE)
	int stctdelete (int commcd);
	
} // end interface ShortCommentMapper



