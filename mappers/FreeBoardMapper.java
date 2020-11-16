package edu.spring.posco.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.posco.domain.FreeBoard;

public interface FreeBoardMapper {
	
	String SQL_FREEBOARD_ALL =
			"select * from ${tbl_freeboard} order by ${col_bno} desc ";
	
	String SQL_FREEBOARD_INSERT = 
			"insert into ${tbl_freeboard} (${col_title}, ${col_content}, ${col_memberid})"
			+ " values ( #{title} , #{content} , #{memberid})";
	      
	String SQL_FREEBOARD_UPDATE = 
			"update ${tbl_freeboard} "
			+ "set ${col_title} = #{title}, ${col_content} = #{content}, ${col_reg_date} = reg_date "
			+ "where ${col_bno} = #{bno}";
	
	String SQL_FREEBOARD_DELETE = 
			"delete from ${tbl_freeboard} where ${col_bno} = #{bno}";
	
	String SQL_FREEBOARD_SEARCH = 
			"select * from ${tbl_freeboard} "
			+ " where ${col_bno} = #{bno} ";
	
	String SQL_FREEBOARD_REPLYCNT = 
			"update ${tbl_freeboard} "
			+ "set ${col_reply_cnt} = ${col_reply_cnt} + #{increase} "
			+ "where ${col_bno} = #{bno}";


	@Select(SQL_FREEBOARD_ALL)
	List<FreeBoard> boardAll();
	
	@Insert(SQL_FREEBOARD_INSERT)
	Integer insertBoard(FreeBoard freeBoard);
	
	@Update(SQL_FREEBOARD_UPDATE)
	int updateBoard(FreeBoard freeBoard);
	
	@Delete(SQL_FREEBOARD_DELETE)
	int deleteBoard(int bno);

	@Select(SQL_FREEBOARD_SEARCH)
	FreeBoard searchBoard(int bno);
	
	@Update(SQL_FREEBOARD_REPLYCNT)
	int updateReplyCnt(@Param("bno") int bno, @Param("increase")int increase);
	

}
