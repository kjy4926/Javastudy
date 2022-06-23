package kgitbank.boostcamp.jy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kgitbank.boostcamp.jy.vo.BookVO;

@Mapper
public interface BookDao {
	public List<BookVO> selectList() throws Exception;
	public List<BookVO> selectByTitle(String title) throws Exception;
	public boolean insert(BookVO bookVO) throws Exception;
}