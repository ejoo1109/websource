package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.UserVO;
import static persistence.JDBCUtil.*;

public class UserDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO(Connection con) {
		this.con=con;
	}
	
	//CRUD 작업
	//insert
	public int insert(String username,String birthyear,String addr,String mobile) {
		//addPro에서 넘긴값 받아오기
		
		int result =0;
		try {
			if(con!=null){ //seq.nextval => 다음 고유번호를 자동생성//insert문의 select절에서만 사용가능
				String sql="insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setInt(2, Integer.parseInt(birthyear));
				pstmt.setString(3, addr);
				pstmt.setString(4, mobile);
				//6. sql구문 실행하고 결과 받기
				result=pstmt.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				close(pstmt);
			}

		
		return result;
	}//insert
	
	//Read
	//전체조회
	public List<UserVO> select() {
				
		List<UserVO> list = new ArrayList<UserVO>(); //VO도 개수가 많아지므로 array로 보냄
		try {
			if(con!=null){
				String sql = "select * from userTBL order by no desc";
				//5.Statement 생성 후 전송: DB연결을 통해 sql문을 수행해 주는 클래스
				pstmt= con.prepareStatement(sql);
				//6.sql 구문 실행 하고 결과 받기 
				//select 구문 executeQuery() => ResultSet,
				//insert,update,delete 구문 excuteUpdate()=> int로 돌려줌
				 rs = pstmt.executeQuery();
				//7.결과를 출력 (ResultSet : DB Select 결과를 담는 특수한 테이블구조 객체)
				//resultset은 바로 출력이 안됨 db테이블 열 순번(타입)으로 지정해서 가져오기
				while (rs.next()){
					//결과 담을 UserVO객체 생성
					UserVO user = new UserVO();
					user.setNo(rs.getInt(1));	//no(number)
					user.setUsername(rs.getString(2)); //username(nchar)
					user.setBirthyear(rs.getInt(3)); //birthYear(number)
					user.setAddr(rs.getString(4)); //addr(nchar)
					user.setMobile(rs.getString(5)); //mobile(nvarchar2)
					list.add(user);
					
				}//while
			}//if
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				close(rs);
				close(pstmt);
			
	}	return list;

}//개별조회
	public UserVO getUser(int no) {
	
		UserVO user= null;
		try{
		
			if(con!=null){
				String sql = "select * from userTBL where no=?";
				//? 사용자의 입력값에 따라 입력되므로 ? 지정
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				//? 조건문이 여러개일때는 while, ? 조건문이 하나일때는 if로 사용
				if(rs.next()){
					user= new UserVO();
					user.setNo(rs.getInt("no")); //컬럼명으로 써도가능
					user.setUsername(rs.getString("username"));
					user.setAddr(rs.getString("addr"));
					user.setMobile(rs.getString("mobile"));
					user.setBirthyear(rs.getInt("birthyear"));
					
				}//if
			}//if con!
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				close(rs);
				close(pstmt);
		}
		return user;
	}
	
	//delete
	public int deleteUser(int no) {
	
		int result=0;
		try{	//no에 해당하는 user 삭제
			
				if(con!=null){
				//삭제가 성공하면 index.jsp로 이동
				String sql = "delete from userTBL where no=?";
				pstmt= con.prepareStatement(sql);
				pstmt.setInt(1, no); //받은걸 파라미터로 보냄
				result = pstmt.executeUpdate();	
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				close(pstmt);
		}
		return result;
	}
	
	//update
	
	public int updateUser(int no, String addr,String mobile) {
	
		int result = 0;
		
		try{ 
				if(con!=null){
				String sql="update userTBL set addr=?, mobile=? where no=?";
				UserVO user = new UserVO();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, addr);
				pstmt.setString(2, mobile);
				pstmt.setInt(3, no);
				result=pstmt.executeUpdate();
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
				close(pstmt);			
		}
		return result;
	}
}


















