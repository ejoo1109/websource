<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%//delete.jsp 에서 받아서 db작업 ,받을때는 스트링밖에 못받으니깐 인트로 형변환
		int code = Integer.parseInt(request.getParameter("code"));
		BookDAO dao = new BookDAO();
		int result = dao.bookDelete(code);
				
		if(result == 0){
			response.sendRedirect("../index.jsp?tab=delete");
		}else{//삭제성공시 select로 이동
			response.sendRedirect("selectPro.jsp");
		}
				
%>
