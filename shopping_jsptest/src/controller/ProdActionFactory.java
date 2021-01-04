package controller;

import action.Action;
import action.ProdAddAction;
import action.ProdListAction;

public class ProdActionFactory {
	private static ProdActionFactory factory;
	private ProdActionFactory() {}
	
	public static ProdActionFactory getInstance() {
		if(factory == null) {
			factory = new ProdActionFactory();
		}
		return factory;
	}
	public Action action (String cmd) {
		Action action = null;
		
		if(cmd.equals("/insert.do")) {
			action=new ProdAddAction("list.do");
		}else if(cmd.equals("/list.do")) {
			action=new ProdListAction("product_list.jsp");
	}
		return action;
}
}
