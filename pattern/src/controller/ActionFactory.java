package controller;

import action.Action;
import action.DeleteAciton;
import action.InsertAction;

//action을 만들어서 리턴하는곳
public class ActionFactory {
	//싱글톤 패턴 - 객체가 없을경우 하나만 생성함. 있을경우 있는걸로 리턴
	private static ActionFactory factory;
	private ActionFactory() {}  //객체생성할때 제한을 두고싶음
	
	public static ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}	
	
	
	public Action action(String cmd) {
		Action action = null;
		//deleteaction과 insertaction의 부모가 action인터페이스므로 코드간소화
		if(cmd.equals("/insert.do")) {
			action = new InsertAction("index.jsp");
		}else if(cmd.equals("/delete.do")) {
			action = new DeleteAciton("index.jsp");	
		}else if(cmd.equals("/update.do")) {
			
		}else if(cmd.equals("/select.do")) {
		
		}
		return action;
	
	
	}
}
