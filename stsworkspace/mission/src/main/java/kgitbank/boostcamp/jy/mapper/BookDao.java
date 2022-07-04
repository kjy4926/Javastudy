package kgitbank.boostcamp.jy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kgitbank.boostcamp.jy.vo.BookVO;
import kgitbank.boostcamp.jy.vo.PageVO;

@Mapper
public interface BookDao {
	public List<BookVO> selectList(PageVO pageVO) throws Exception;
	public List<BookVO> selectByTitle(PageVO pageVO) throws Exception;
	public BookVO selectById(long id) throws Exception;
	public Long getBooksRowCount();
	public Long getSearchBooksRowCount(String title);
	public boolean insert(BookVO bookVO) throws Exception;
}