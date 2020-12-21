package service;

import java.util.List;

import domain.BookVO;

public interface BookService {
	//crud작업
	public boolean insertBook(BookVO vo);
	public boolean updateBook(BookVO vo);
	public boolean deleteBook(int no);
	
	public List<BookVO> getRows(String criteria,String keyword);
	public List<BookVO> getList();
	
}
