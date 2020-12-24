package persistence;
import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;
import domain.SearchVO;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO(Connection con) {
		this.con=con;
	}
	
	//CRUD
	//글쓰기
	public int insert(BoardVO vo) {
		String sql = "insert into board(bno,name,password,title,content,"
				+"attach,re_ref,re_lev,re_seq) "
				+"values(board_seq.nextval,?,?,?,?,?,board_seq.currval,0,0)";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getAttach());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	//전체조회
//	public List<BoardVO> selectAll(){
//		String sql="select bno, title, name, regdate,readcount,re_lev from board order by re_ref desc,re_seq asc";
//		List<BoardVO> list = new ArrayList<BoardVO>();
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			rs=pstmt.executeQuery();
//			
//			while(rs.next()) {
//			BoardVO vo= new BoardVO();
//			vo.setBno(rs.getInt("bno"));
//			vo.setTitle(rs.getString("title"));
//			vo.setName(rs.getString("name"));
//			vo.setRegdate(rs.getDate("regdate"));
//			vo.setReadcount(rs.getInt("readcount"));
//			vo.setRe_lev(rs.getInt("re_lev"));
//			list.add(vo);
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		return list;
//	}//전체조회 끝
	
	//검색기능 시작, 필드명은 '?' 사용못함
//	public List<BoardVO> searchAll(SearchVO searchVO){
//		List<BoardVO> search = new ArrayList<BoardVO>();
//				
//		String sql="select bno, title, name, regdate,readcount,re_lev from board ";
//		sql+="where "+searchVO.getCriteria()+" like ? order by re_ref desc,re_seq asc";
//		
//		try {
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1, "%"+searchVO.getKeyword()+"%"); //물음표 셋팅
//			rs=pstmt.executeQuery();
//			
//			while(rs.next()) {
//				BoardVO vo= new BoardVO();
//				vo.setBno(rs.getInt("bno"));
//				vo.setTitle(rs.getString("title"));
//				vo.setName(rs.getString("name"));
//				vo.setRegdate(rs.getDate("regdate"));
//				vo.setReadcount(rs.getInt("readcount"));
//				vo.setRe_lev(rs.getInt("re_lev"));
//				search.add(vo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			close(rs);
//			close(pstmt);
//		}
//		return search;
//	}//검색기능 종료
	
	// 전체 조회 list + 검색 리스트 search 구현
	public List<BoardVO> getList(SearchVO searchVO){	
		
//		select bno,title,name, regdate,readcount,re_lev
//		from(select rownum rnum,bno,title,name, regdate,readcount,re_lev
//				from(select bno,title,name, regdate,readcount,re_lev
//						from board 
//						where bno>0 order by re_ref desc, re_seq asc)
//				where rownum<=20)
//		where rnum>10;
		
		//문자열 String
		//StringBuffer(스레드지원), StringBuilder(스레드미지원)-> 둘다 append()사용가능
		int start = searchVO.getPage()*searchVO.getAmount();
		int limit = (searchVO.getPage()-1)*searchVO.getAmount();
		List<BoardVO> list = new ArrayList<BoardVO>();
		StringBuilder builder = new StringBuilder();
		
		try {
			
			String sql="";
			
			if(searchVO.getCriteria()!=null) { //검색
			//	sql="select bno, title, name, regdate,readcount,re_lev from board ";
			//	sql+="where "+searchVO.getCriteria()+" like ? order by re_ref desc,re_seq asc";
	
				builder.append("select bno,title,name, regdate,readcount,re_lev ");
				builder.append("from(select rownum rnum,bno,title,name, regdate,readcount,re_lev ");
				builder.append("from(select bno,title,name, regdate,readcount,re_lev ");
				builder.append("from board ");
				builder.append("where bno>0 and "+searchVO.getCriteria()+" like ? ");
				builder.append("order by re_ref desc, re_seq asc) ");
				builder.append("where rownum<=?) ");
				builder.append("where rnum>?");				
				pstmt = con.prepareStatement(builder.toString());
				//물음표 셋팅
				pstmt.setString(1, "%"+searchVO.getKeyword()+"%"); 
				pstmt.setInt(2, start); //(1-1)*10, 1*10
				pstmt.setInt(3, limit); //(2-1)*10, 2*10
				
			}else { //일반 리스트
			//	sql="select bno, title, name, regdate,readcount,re_lev from board order by re_ref desc,re_seq asc";
				builder.append("select bno,title,name, regdate,readcount,re_lev ");
				builder.append("from(select rownum rnum,bno,title,name, regdate,readcount,re_lev ");
				builder.append("from(select bno,title,name, regdate,readcount,re_lev ");
				builder.append("from board ");
				builder.append("where bno>0 order by re_ref desc, re_seq asc) ");
				builder.append("where rownum<=?) ");
				builder.append("where rnum>?");
				pstmt = con.prepareStatement(builder.toString());
				//물음표 셋팅
				pstmt.setInt(1, start);
				pstmt.setInt(2, limit);
			}
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			BoardVO vo= new BoardVO();
			vo.setBno(rs.getInt("bno"));
			vo.setTitle(rs.getString("title"));
			vo.setName(rs.getString("name"));
			vo.setRegdate(rs.getDate("regdate"));
			vo.setReadcount(rs.getInt("readcount"));
			vo.setRe_lev(rs.getInt("re_lev"));
			list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}//전체조회 끝
	
	//개별조회-qna_board_view에서 필요한 값들+pk값 sql문으로 조회해서 세팅하기
	public BoardVO select(int bno) {
		String sql = "select bno,name,title,content,attach,re_ref,re_lev,re_seq from board where bno=?";
		BoardVO vo=null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno); //물음표 세팅
			rs = pstmt.executeQuery();
			
			if(rs.next()) { //vo에 담기
				vo = new BoardVO();
				vo.setBno(rs.getInt("bno"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setAttach(rs.getString("attach"));
				//reply에 필요한 값
				vo.setRe_ref(rs.getInt("re_ref"));
				vo.setRe_lev(rs.getInt("re_lev"));
				vo.setRe_seq(rs.getInt("re_seq"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	//조회수 올리기
	public int readCountUpdate(int bno) {
		String sql = "update board set readcount=readcount+1 where bno=?";
		int result = 0;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	//삭제하기
	public int delete(int bno,String password) {
		String sql="delete from board where bno=? and password=?";
		int result =0;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			pstmt.setString(2,password);
			result = pstmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	//수정하기
	public int update(BoardVO vo) {
		//경우의 수가 2개이므로 try안에 if문을 사용하여 sql 2개로 작성
		int result=0;
		String sql="";
		
		try {
			if(vo.getAttach()!=null) { //title,content,attach 수정할 경우
			sql = "update board set title=?,content=?,attach=? where bno=? and password=?";
			 pstmt=con.prepareStatement(sql);
			 pstmt.setString(1,vo.getTitle());
			 pstmt.setString(2,vo.getContent());
			 pstmt.setString(3, vo.getAttach());
			 pstmt.setInt(4, vo.getBno());
			 pstmt.setString(5, vo.getPassword());
			 
			}else { //title,content만 수정할 경우
				sql = "update board set title=?,content=? where bno=? and password=?";
				 pstmt=con.prepareStatement(sql);
				 pstmt.setString(1,vo.getTitle());
				 pstmt.setString(2,vo.getContent());
				 pstmt.setInt(3, vo.getBno());
				 pstmt.setString(4, vo.getPassword());
			}
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;

	}//수정하기
	
	//답글달기
	public int reply(BoardVO vo) {
		int result=0;
		
		try {
			//원본글 정보 가져오기
			int re_ref = vo.getRe_ref();
			int re_seq = vo.getRe_seq();
			int re_lev = vo.getRe_lev();
		
		//원본글에 달려있는 기존 댓글 업데이트
		String sql="update board set re_seq = re_seq+1 where re_ref=? and re_seq>?";
		pstmt = con.prepareStatement(sql);
		//물음표 셋팅
		pstmt.setInt(1, re_ref);
		pstmt.setInt(2, re_seq);
		int updateCount = pstmt.executeUpdate();
		
		//업데이트가 끝나야하기 때문에 commit 작업
		if(updateCount>0) {
			commit(con);
		}
		close(pstmt);
		
		//댓글삽입 :댓글에는 attach가 없으므로 null
		sql="insert into board(bno,name,password,title,content,attach,re_ref,re_lev,re_seq) "
				+"values(board_seq.nextval,?,?,?,?,null,?,?,?)";
		pstmt = con.prepareStatement(sql);
		//물음표 셋팅
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getTitle());
		pstmt.setString(4, vo.getContent());
		pstmt.setInt(5, re_ref);
		pstmt.setInt(6, re_lev+1);
		pstmt.setInt(7, re_seq+1);
		result = pstmt.executeUpdate();		
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
		
	}
}