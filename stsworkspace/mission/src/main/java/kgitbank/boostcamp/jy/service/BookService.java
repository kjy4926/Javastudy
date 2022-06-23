package kgitbank.boostcamp.jy.service;

import java.util.List;

import kgitbank.boostcamp.jy.vo.BookVO;

public interface BookService {
	public List<BookVO> selectBookList(); 
	public List<BookVO> searchBookList(String title);
	public boolean bookInsert(BookVO bookVO);
}