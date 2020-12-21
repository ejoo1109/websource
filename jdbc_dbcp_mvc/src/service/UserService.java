package service;

import java.util.List;

import domain.UserVO;

public interface UserService {
	//CRUD 서비스를 할 수 있도록 메소드 구성
	public boolean insertUser(String username,String birthyear,String addr,String mobile);
	public boolean updateUser(int no, String addr,String mobile);
	public boolean deleteUser(int no);
	
	//개별조회
	public UserVO getUser(int no);
	//전체조회
	public List<UserVO> getUserList();

}
