package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static persistence.JDBCUtil.*; //JDBC.colse로 사용안하고 그냥 close로 사용하고 싶을때

public class MemberDAO {
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO(Connection con) {
		this.con = con;
	}
	
	public int insert(String name) {
		int result = 0;
		
		try {
			pstmt=con.prepareStatement("insert into memeberTBL values()");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int delete(String name) {
		System.out.println("memberDAO delete :"+name);
		return 1;
	}
}
