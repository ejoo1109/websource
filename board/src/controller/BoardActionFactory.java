package controller;

import action.Action;
import action.BoardHitUpdateAction;
import action.BoardListAciton;
import action.BoardViewAction;
import action.BoardWriteAction;

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
			action = new BoardWriteAction("index.html");
		}else if(cmd.equals("/qList.do")) {
			action = new BoardListAciton("view/qna_board_list.jsp");
		}else if(cmd.equals("/qView.do")) {
			action = new BoardViewAction("view/qna_board_view.jsp");
		}else if(cmd.equals("/qHitUpdate.do")) {
			action = new BoardHitUpdateAction("qView.do"); //조회수 올리고 나오는 페이지
		}
		
		
		return action;
	}
}
