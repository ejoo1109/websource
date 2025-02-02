package controller;

import action.Action;
import action.BookDeleteAction;
import action.BookInsertAction;
import action.BookListAction;
import action.BookModifyAction;
import action.BookSearchAction;

public class BookActionFactory {
	//싱글톤 패턴
	private static BookActionFactory factory;
	private BookActionFactory() {}
	
	public static BookActionFactory getInstance() {
		if(factory==null) {
			factory = new BookActionFactory();
		}
		return factory;
	}
	
	public Action action (String cmd) {
		Action action = null;
		
		if(cmd.equals("/list.do")) {
			action=new BookListAction("select.jsp");
		}else if(cmd.equals("/insert.do")) {
			action = new BookInsertAction("list.do");
		}else if(cmd.equals("/delete.do")) {
			action = new BookDeleteAction("list.do");
		}else if(cmd.equals("/modify.do")) {
			action = new BookModifyAction("list.do");
		}else if(cmd.equals("/search.do")) {
			action = new BookSearchAction("searchAll.jsp");
		}
		return action;
	}
}
