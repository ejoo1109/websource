package controller;

import action.Action;

public class BoardActionFactory {
	private static BoardActionFactory baf;
	
	private BoardActionFactory() {}
	public static BoardActionFactory getInstance() {
		if(baf==null) {
			baf= new BoardActionFactory();
		}
		return baf;
	}
	public Action action(String cmd) {
		Action action = null;
		
		if(cmd.equals("/qWrite.do")) {
			
		}
		return action;
	}
}
