package edu.spring.posco.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.posco.domain.BoardReply;
import edu.spring.posco.domain.Rvreply;

public interface BoardReplyMapper {
	
	String SQL_BOARDREPLY_ALL = 
			"select * from ${tbl_boardreply}";
	String SQL_BOARDREPLY_INSERT = 
			"insert into ${tbl_boardreply} (${col_bno}, ${col_memberid}, ${col_frtext})"
			+ "values ( #{bno}, #{memberid}, #{frtext})";
	String SQL_BOARDREPLY_UPDATE = 
			"update ${tbl_boardreply} "
			+ "set ${col_frtext} = #{frtext} "
			+ "where ${col_boardreplycd} = #{boardreplycd}";
	String SQL_BOARDREPLY_DELETE = 
			"delete from ${tbl_boardreply} "
			+ "where ${col_boardreplycd} = #{boardreplycd}";
	String SQL_BOARDREPLY_SEARCH = 
			"select * from ${tbl_boardreply} "
			+ "where ${col_bno} = #{bno}";
	
	String SQL_BOARDREPLY_SEARCH_BOARDREPLYCD = 
			"select * from ${tbl_boardreply} "
			+ "where ${col_boardreplycd} = #{boardreplycd}";
	
	String SQL_READ_BOARDREPLYCD = 
			"select ${col_bno} from ${tbl_boardreply} "
			+ "where ${col_boardreplycd} = #{boardreplycd}";
	
	
	String SQL_BOARDREPLY_DELETE_BY_BNO = 
			"delete from ${tbl_boardreply} "
			+ "where ${col_bno} = #{bno}";
	
	@Select(SQL_BOARDREPLY_ALL)
	List<BoardReply> boardReplyAll();
	
	@Insert(SQL_BOARDREPLY_INSERT)
	int insertBoardReply(BoardReply boardReply);
	
	@Update(SQL_BOARDREPLY_UPDATE)
	int updateBoardReply(BoardReply boardReply);
	
	
	@Delete(SQL_BOARDREPLY_DELETE)
	int deleteBoardReply(int boardreplycd);
	
	@Select(SQL_BOARDREPLY_SEARCH)
	List<BoardReply> searchBoardReply(int bno);
	
	@Select(SQL_BOARDREPLY_SEARCH_BOARDREPLYCD)
	BoardReply selectboardreply(int boardreplycd);
	
	@Select(SQL_READ_BOARDREPLYCD )
	Integer readBoardReplycd(int boardreplycd);
	
	@Delete(SQL_BOARDREPLY_DELETE_BY_BNO)
	Integer deleteBoardReplyByBno(int bno);
}
