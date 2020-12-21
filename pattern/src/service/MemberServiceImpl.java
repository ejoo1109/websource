package service;

import java.sql.Connection;
import java.util.List;

import static persistence.JDBCUtil.*;

import domain.MemberVO;
import persistence.MemberDAO;

public class MemberServiceImpl implements MemberService {
	
	private Connection con;
	private MemberDAO dao;
	
	public MemberServiceImpl() {
		con=getConnection();
		//db작업
		dao = new MemberDAO(con);		
	}

	@Override
	public boolean insertMember(String name) {
		System.out.println("insert_service : "+name);
		
		boolean insertFlag = false;
		if(dao.insert(name)>0) {
			insertFlag=true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return insertFlag;
		
		//return dao.insert(name)>0?true:false;
		//원래 int리턴타입으로 result로 넘어와서 result>0으로 진행한것을 불린타입 삼항식으로 변경한것
	}

	@Override
	public boolean updateMember(String name) {
	
		return false;
	}

	@Override
	public boolean deleteMember(String name) {
		System.out.println("delete_service : "+name);
		return dao.delete(name)>0?true:false;
	}

	@Override
	public MemberVO getMember(String name) {
		
		return null;
	}

	@Override
	public List<MemberVO> getList() {
		
		return null;
	}

}
