package kgitbank.boostcamp.jy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kgitbank.boostcamp.jy.mapper.BookDao;
import kgitbank.boostcamp.jy.vo.BookVO;
import kgitbank.boostcamp.jy.vo.PageVO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private final BookDao bookDao;
	
	@Override
	@Transactional
	public List<BookVO> selectBookList(PageVO pageVO) {
		try {return bookDao.selectList(pageVO);} 
		catch (Exception e) {e.printStackTrace(); return null;}
	}
	@Override
	public List<BookVO> searchBookList(PageVO pageVO) {
		try {return bookDao.selectByTitle(pageVO);
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
	@Override
	public Long getMaxPageNum() {
		Long rowCount = bookDao.getBooksRowCount();
		Long maxPage = rowCount % 10 == 0 ? rowCount/10 : rowCount/10 + 1;
		return maxPage;
	}
	@Override
	public Long getSearchMaxPageNum(String title) {
		Long rowCount = bookDao.getSearchBooksRowCount(title);
		Long maxPage = rowCount % 10 == 0 ? rowCount/10 : rowCount/10 + 1;
		return maxPage;
	}
}
