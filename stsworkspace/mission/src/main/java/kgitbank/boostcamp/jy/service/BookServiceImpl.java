package kgitbank.boostcamp.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kgitbank.boostcamp.jy.mapper.BookDao;
import kgitbank.boostcamp.jy.vo.BookVO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private final BookDao bookDao;
	
	@Override
	@Transactional
	public List<BookVO> selectBookList() {
		try {return bookDao.selectList();} 
		catch (Exception e) {e.printStackTrace(); return null;}
	}

	@Override
	public List<BookVO> searchBookList(String title) {
		try {return bookDao.selectByTitle(title);
		} catch (Exception e) {e.printStackTrace(); return null;}
	}

	@Override
	public boolean bookInsert(BookVO bookVO) {
		try {
			bookDao.insert(bookVO);
			return true;
		} catch (Exception e) {e.printStackTrace(); return false;}
	}

	@Override
	public BookVO readBook(long id) {
		try {return bookDao.selectById(id);} 
		catch (Exception e) {e.printStackTrace(); return null;}
	}
}
