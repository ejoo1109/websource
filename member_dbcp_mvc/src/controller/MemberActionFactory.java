package controller;

import action.Action;
import action.MemberJoinAction;
import action.MemberLeaveAction;
import action.MemberLoginAction;
import action.MemberModifyAction;

public class MemberActionFactory {
//싱글톤 패턴
	private static MemberActionFactory factory;
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if(factory == null) {
			factory = new MemberActionFactory();
		}
		return factory;
	}
	
	public Action action(String cmd) {
		Action action = null;
	//	member_dbcp_mvc/login.do
		if(cmd.equals("/login.do")) {
			action = new MemberLoginAction("view/loginForm.jsp");// /login.do 에서 돌아가려면 view/login으로 지정해줘야한다.
		}else if(cmd.equals("/modify.do")) {
			action = new MemberModifyAction("view/loginForm.jsp");
		}else if(cmd.equals("/leave.do")) {
			action = new MemberLeaveAction("index.jsp");
		}else if(cmd.equals("/join.do")) {
			action = new MemberJoinAction("view/loginForm.jsp");
		}
		return action;
	}
}
//http://localhost:8080/member_dbcp_mvc/view/loginForm.jsp
//http://localhost:8080/member_dbcp_mvc/login.do 로 이동해야하니깐 ../login.do로 사용함
