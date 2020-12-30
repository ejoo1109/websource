package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import domain.MemberVO;
import static persistence.JDBCUtil.*;

//JDBCUtil import추가

public class MemberDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO(Connection con) {
		this.con=con;
	}
	
	
	public MemberVO isLogin(String userid, String password) {
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
				close(pstmt);
		}return member;
	}//connection
	
	//회원가입
	//insert into memberTBL(부분만 입력될경우 필드명 반드시 기재해야함) values(?,?,?,?,?)
	public int resister(MemberVO member) {

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
				close(pstmt);
		}return result;
	}

	
	//비밀번호 수정 update
	//update memberTBL set password=? where userid=userid;
	public int updateMember(String userid,String password) {

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
				close(pstmt);
			
		}return result;
	}//update
	
	//회원탈퇴
	//delete from memberTBL where userid=? and password=?
	
	public int leaveMember(String userid, String password) {
	
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
				close(pstmt);
		}return result;
	}
	//중복아이디
	public boolean checkId(String userid) {
		boolean result = false;
		
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
				close(rs);
				close(pstmt);
		}
		return result;
	}
}
