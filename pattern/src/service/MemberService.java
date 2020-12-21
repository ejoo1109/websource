package service;

import java.util.List;

import domain.MemberVO;

public interface MemberService {
	//DAO와 연동- C(insert)R(select)U(update)D(delete)
	//insert,update,delete는 리턴타입이 int ->리턴타입을 boolean으로 만듬
	//select ->리턴타입 list, vo 두개
	
	public boolean insertMember(String name);
	public boolean updateMember(String name);
	public boolean deleteMember(String name);
	
	public MemberVO getMember(String name);
	public List<MemberVO> getList();
	
	
}
