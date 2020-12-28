<%@page import="book1.BookVO"%>
<%@page import="java.util.List"%>
<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//도서목록 보기 메뉴는 클릭하면 보여줄 내용 처리
	BookDAO dao = new BookDAO();
	List<BookVO> list = dao.getList();
	//forward - searchAll.jsp로 이동
	request.setAttribute("list",list);
	pageContext.forward("../searchAll.jsp");

%>