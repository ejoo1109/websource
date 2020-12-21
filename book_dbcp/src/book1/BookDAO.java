package book1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDAO {
	//connection, CRUD
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		}catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
		//커넥션
	public Connection getConnection() {
		Connection con = null;
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
			con=ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//CRUD 작업
	//book insert 
	//insert into bookTBL values(1001,'이것이 자바다','신영권',28000);
	public int insert(int code, String title, String writer, int price) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			if(con!=null) {
				String sql="insert into bookTBL values(?,?,?,?)";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, code);
				pstmt.setString(2, title);
				pstmt.setString(3, writer);
				pstmt.setInt(4, price);
				result=pstmt.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return result;
	}//insert
	
	//전체조회
	public List<BookVO> getList(){
		Connection con = getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
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
			try {
				pstmt.close();
				rs.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} return list;
	}
	//전체조회
	//삭제 delete from booktbl where code=?
	public int bookDelete(int code) {
		Connection con=getConnection();
		PreparedStatement pstmt=null;
		int result=0;
		try{	
			
				String sql = "delete from bookTBL where code=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, code); //받은걸 파라미터로 보냄
				result = pstmt.executeUpdate();	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				con.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}

		}
		return result;
	} //delete
	
	//update
	//update bookTBL set price=? where code=?
	public int bookUpdate(int price,int code) {
		Connection con = getConnection();
		PreparedStatement pstmt=null;
		int result = 0;
		
		try {
			String sql="update bookTBL set price=? where code=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, price);
			pstmt.setInt(2, code);
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
		Connection con = getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
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
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return list;

	}
	
}
