package kgitbank.boostcamp.jy.service;

import java.util.List;

import kgitbank.boostcamp.jy.vo.BookVO;
import kgitbank.boostcamp.jy.vo.PageVO;

public interface BookService {
	public List<BookVO> selectBookList(PageVO pageVO); 
	public List<BookVO> searchBookList(PageVO pageVO);
	public BookVO readBook(long id);
	public boolean bookInsert(BookVO bookVO);
	public Long getMaxPageNum();
	public Long getSearchMaxPageNum(String title);
}