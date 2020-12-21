package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import domain.BookVO;
import static persistence.JDBCUtil.*;

public class BookDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BookDAO(Connection con) {
		this.con=con;
	}


	//book insert 
	//insert into bookTBL values(1001,'이것이 자바다','신영권',28000);
	public int bookinsert(BookVO vo) {
		int result = 0;
		try {
				String sql="insert into bookTBL values(?,?,?,?)";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, vo.getCode());
				pstmt.setString(2, vo.getTitle());
				pstmt.setString(3, vo.getWriter());
				pstmt.setInt(4, vo.getPrice());
				result=pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}//insert
	
	//전체조회
	public List<BookVO> getList(){
			
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			if(con!=null) {
				String sql = "select * from bookTBL order by code desc";
				pstmt=con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next()) {
					BookVO vo = new BookVO();
					vo.setCode(rs.getInt(1));
					vo.setTitle(rs.getString(2));
					vo.setWriter(rs.getString(3));
					vo.setPrice(rs.getInt(4));
					list.add(vo);		
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(pstmt);
				close(rs);
		} return list;
	}
	//전체조회
	//삭제 delete from booktbl where code=?
	public int bookDelete(int code) {

		int result=0;
		try{	
				String sql = "delete from bookTBL where code=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, code); //받은걸 파라미터로 보냄
				result = pstmt.executeUpdate();	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	} //delete
	
	//update
	//update bookTBL set price=? where code=?
	public int bookUpdate(BookVO vo) {
		int result = 0;
		
		try {
			String sql="update bookTBL set price=? where code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, vo.getPrice());
			pstmt.setInt(2, vo.getCode());
			result = pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(pstmt);
		}return result;
		
	}//update
	
	//search
	
	public List<BookVO> bookSearch(String critera, String keyword) {
		//코드가 2001번 검색하기 //sql문의 필드명은 필수조건 값만 ? 처리가능
		//select * from bookTBL where code=?
		//작가가 홍길동 검색하기
		//select * from bookTBL where writer=?"
		//한 name에 value가 한가지 타입이고 선택하는 값이 2개일경우 name으로 바로 사용가능 
		//String sql = "select * from bookTBL where" + critera + "= ?";
	
		String sql="";
		
		List<BookVO> list = new ArrayList<BookVO>();
		try {
			if(critera.equals("code")) {
			sql="select * from bookTBL where code=?";
		    pstmt=con.prepareStatement(sql);	
		    pstmt.setInt(1, Integer.parseInt(keyword));
	} else {		    
			sql="select * from bookTBL where writer=?";
			pstmt=con.prepareStatement(sql);	
			pstmt.setString(1, keyword);
			}
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				vo.setCode(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setWriter(rs.getString(3));
				vo.setPrice(rs.getInt(4));
				list.add(vo);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				close(rs);
				close(pstmt);
		}return list;

	}
	
}
