package member;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	//드라이버 로드
	
//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
	//Connection
	public Connection getConnection() {
			Connection con = null;
		
			try {
				Context ctx=new InitialContext();
				DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/Oracle");
				con=ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
		}return con;
		
	}//Connection
	
	//로그인(개별조회) = userid, password가 일치하면 로그인 성공
	//select userid, name from member where userid=? and password=?
	
	public MemberVO isLogin(String userid, String password) {
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		MemberVO member = null;
		try {
			String sql = "select userid, name from memberTBL where userid=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userid);
			pstmt.setString(2,password);
			rs=pstmt.executeQuery();
			//sql문 조건셋팅
			
			if(rs.next()) {
				member=new MemberVO();
				member.setUserid(rs.getString("userid"));
				member.setName(rs.getString("name"));	
			//memberVo에서 가져올 정보를 get으로 가져온 후 set에 담는다.
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
		}return member;
	}//connection
	
	//회원가입
	//insert into memberTBL(부분만 입력될경우 필드명 반드시 기재해야함) values(?,?,?,?,?)
	public int resister(MemberVO member) {
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "insert into memberTBL(userid,password,name,gender,email) values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,member.getUserid());
			pstmt.setString(2,member.getPassword());
			pstmt.setString(3,member.getName());
			pstmt.setString(4,member.getGender());
			pstmt.setString(5,member.getEmail());
			result=pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				con.close(); //con을 제일 마지막에 닫는다.
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}return result;
	}
	//한사람의 정보가 다 들어온다면 매개변수를 MemberVO로 사용한다.
//	public int resister(MemberVO member) {
//		
//		Connection con = getConnection();
//		PreparedStatement pstmt = null;
//		int result = 0;
//		
//		try {
//			String sql = "insert into memberTBL(userid,password,name,gender,email) values(?,?,?,?,?)";
//			pstmt=con.prepareStatement(sql);
//			pstmt.setString(1,member.getUserid());
//			pstmt.setString(2,member.getPassword());
//			pstmt.setString(3,member.getName());
//			pstmt.setString(4,member.getGender());
//			pstmt.setString(5,member.getEmail());
//			result=pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				pstmt.close();
//				con.close(); //con을 제일 마지막에 닫는다.
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}return result;
//	}//insert
	
	//비밀번호 수정 update
	//update memberTBL set password=? where userid=userid;
	public int updateMember(String userid,String password) {
		Connection con = getConnection();
		PreparedStatement pstmt=null;
		int result = 0;
		
		try {
			String sql = "update memberTBL set password=? where userid=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, userid);
			result=pstmt.executeUpdate();
			
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
	
	//회원탈퇴
	//delete from memberTBL where userid=? and password=?
	
	public int leaveMember(String userid, String password) {
		Connection con = getConnection();
		PreparedStatement pstmt=null;
		int result = 0;
		
		try {
			String sql = "delete from memberTBL where userid=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, password);
			result=pstmt.executeUpdate();
			
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
	}
	
	//중복아이디
	public boolean checkId(String userid) {
		boolean result = false;
		Connection con = getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		String sql = "select userid from memberTBL where userid=?";
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
