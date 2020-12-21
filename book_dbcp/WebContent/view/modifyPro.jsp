<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//modify.jsp에서 넘긴값 가져오기
//db작업해주기
//성공하면 index로 이동
	request.setCharacterEncoding("utf-8");
	int code = Integer.parseInt(request.getParameter("code"));
	int price = Integer.parseInt(request.getParameter("price"));

	BookDAO dao = new BookDAO();
	int result = dao.bookUpdate(price,code); //넘겨 받아올때에는 순서 지켜서 받아와야함
	
	if (result==0){ //수정 실패시 modify 페이지
		response.sendRedirect("../index.jsp?tab=modify");
	}else {//수정성공시 select.jsp
		response.sendRedirect("selectPro.jsp");
	}
%>