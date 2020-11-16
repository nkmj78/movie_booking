package edu.spring.posco.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.spring.posco.domain.BoxOffice;

public interface BoxOfficeMapper {
	
	String SQL_BOXOFFICE_LISTUP = "insert into ${tbl_boxoffice} (moviecd, rank, movienm, opendt, audiacc)"
			+ "values (#{moviecd}, #{rank}, #{movienm}, #{opendt}, #{audiacc})";
	@Insert(SQL_BOXOFFICE_LISTUP)
	int boxList(BoxOffice box);
	
	
	
	String SQL_BOXOFFICE_SHIFT = "delete from ${tbl_boxoffice}";
	@Delete(SQL_BOXOFFICE_SHIFT)
	int boxShift();
	
	String SQL_BOXOFFICE_SELECTALL = "select * from ${tbl_boxoffice} order by rank";
	@Select(SQL_BOXOFFICE_SELECTALL)
	List<BoxOffice> boxSelectAll();
}
