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
		boolean insertFlag = false;
		
		int result = dao.insert(vo);
		if(result>0) {
			commit(con);
			insertFlag=true;
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
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
		List<BoardVO> list=dao.selectAll();
		close(con);
		return list;
	}

	@Override
	public BoardVO getRow(int bno) {
		BoardVO vo=dao.select(bno);
		close(con);
		return vo;
	}
	@Override
	public boolean hitUpdate(int bno) {
		boolean updateFlag = false;
		
		int result = dao.readCountUpdate(bno);
		if(result>0) {
			commit(con);
			updateFlag=true;
		}else {
			rollback(con);
		}
		close(con);
		return updateFlag;
	}

}
