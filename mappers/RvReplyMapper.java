package edu.spring.posco.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.spring.posco.domain.Rvreply;

public interface RvReplyMapper {
	
	
	String SQL_RVREPLY_INSERT = 
			"insert into ${tbl_rvreply} (${col_rvcode}, ${col_memberid}, ${col_rvtext})"
			+ "values ( #{rvcode}, #{memberid}, #{rvtext})";
	String SQL_RVREPLY_UPDATE = 
			"update ${tbl_rvreply} "
			+ "set ${col_rvtext} = #{rvtext} "
			+ "where ${col_rvreplycd} = #{rvreplycd}";
	String SQL_RVREPLY_DELETE = 
			"delete from ${tbl_rvreply} "
			+ "where ${col_rvreplycd} = #{rvreplycd}";
	String SQL_RVREPLY_SEARCH = 
			"select * from ${tbl_rvreply} "
			+ "where ${col_rvcode} = #{rvcode}";
	
	String SQL_RVREPLY_SEARCH_RVREPLYCD = 
			"select * from ${tbl_rvreply} "
			+ "where ${col_rvreplycd} = #{rvreplycd}";
	
	String SQL_READ_RVREPLYCD = 
			"select ${col_rvcode} from ${tbl_rvreply} "
			+ "where ${col_rvreplycd} = #{rvreplycd}";
	
	String SQL_RVREPLY_DELETE_RVCODE = 
			"delete from ${tbl_rvreply} "
					+ "where ${col_rvcode} = #{rvcode}";
	
	@Insert(SQL_RVREPLY_INSERT)
	int insertRvreply(Rvreply rvreply);
	
	@Update(SQL_RVREPLY_UPDATE)
	int updateRvreply(Rvreply rvreply);
	
	
	@Delete(SQL_RVREPLY_DELETE)
	int deleteRvreply(int rvreplycd);
	
	@Select(SQL_RVREPLY_SEARCH)
	List<Rvreply> searchRvreply(int rvcode);
	
	@Select(SQL_RVREPLY_SEARCH_RVREPLYCD)
	Rvreply selectRvreply(int rvreplycd);
	
	@Select(SQL_READ_RVREPLYCD)
	Integer readRvreplycd(int rvreplycd);
	
	@Delete(SQL_RVREPLY_DELETE_RVCODE)
	Integer deleteRvreplyByRvcode(int rvcode);
	
} // end interface RvreplyMapper