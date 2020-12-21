package service;

import java.sql.Connection;
import java.util.List;

import domain.UserVO;
import persistence.UserDAO;
import static persistence.JDBCUtil.*;

public class UserServiceImpl implements UserService {
	Connection con;
	UserDAO dao;
	
	
	//기본생성자 만듬
	public UserServiceImpl() {
		con = getConnection();
		dao = new UserDAO(con);
	}
	
	
	@Override
	public boolean insertUser(String username, String birthyear, String addr, String mobile) {
		//pro에서 했던 작업들을 dao에서 시킨다
		//UserDAO 객체 생성 - DB작업 시키기
		int result = dao.insert(username,birthyear,addr,mobile);
		
		//db결과를 action에게 보내기 -> commit, rollback
		boolean insertFlag = false;
		if(result>0) {
			insertFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
	}

	@Override
	public boolean updateUser(int no, String addr, String mobile) {
		int result = dao.updateUser(no,addr,mobile);
		
		boolean updateFlag = false;
		if(result>0) {
			updateFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return updateFlag;
	}

	@Override
	public boolean deleteUser(int no) {
		int result = dao.deleteUser(no);
		
		boolean deleteFlag=false;
		if (result>0) {
			deleteFlag = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return deleteFlag;
	}

	@Override
	public UserVO getUser(int no) {
		UserVO user=dao.getUser(no);
		close(con); //select만 하면 되기 때문에
		return user;
	}

	@Override
	public List<UserVO> getUserList() {
	 	List<UserVO> list=dao.select();
	 	close(con);
		return list;
	}

}
