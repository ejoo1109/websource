package persistence;
import static persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.BoardVO;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO(Connection con) {
		this.con=con;
	}
	
	//CRUD
	
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
	public List<BoardVO> selectAll(){
		String sql="select bno, title, name, regdate,readcount from board order by bno desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
			BoardVO vo= new BoardVO();
			vo.setBno(rs.getInt("bno"));
			vo.setTitle(rs.getString("title"));
			vo.setName(rs.getString("name"));
			vo.setRegdate(rs.getDate("regdate"));
			vo.setReadcount(rs.getInt("readcount"));
			list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
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
			BoardVO vo = new BoardVO();
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
}