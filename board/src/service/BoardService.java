package service;

import java.util.List;

import domain.BoardVO;
import domain.SearchVO;

public interface BoardService {
	//CRUD
	public boolean insertArticle(BoardVO vo);
	public boolean updateArticle(BoardVO vo);
	public boolean deleteArticle(int bno, String password);

	//게시글 전체조회+검색 조회
	public List<BoardVO> getList(SearchVO searchVO);
	//게시글 전체 행 수
	public int getRows(String criteria, String keyword);
	//게시글 특정 번호 조회
	public BoardVO getRow(int bno);
	//조회수 업데이트
	public boolean hitUpdate(int bno);
	//댓글
	public boolean insertReply(BoardVO reply);
	//검색
	//public List<BoardVO> serchList(SearchVO search);
	
}
