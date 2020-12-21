package service;

import java.sql.Connection;
import java.util.List;

import domain.BoardVO;
import persistence.BoardDAO;
import static persistence.JDBCUtil.*;
public class BoardServiceImpl implements BoardService {

	
	private BoardDAO dao;
	private Connection con;
	
	
	public BoardServiceImpl() {
		con= getConnection();
		dao= new BoardDAO(con);
	}
	@Override
	public boolean insertArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO getRow(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

}
