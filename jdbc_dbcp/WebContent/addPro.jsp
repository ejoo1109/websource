<%@page import="jdbc.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//add.jsp에서 사용자 입력값 가져오기
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String birthyear = request.getParameter("birthyear");
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");

	//pro에서 했던 작업들을 dao에서 시킨다
	//UserDAO 객체 생성 - DB작업 시키기
	UserDAO dao = new UserDAO();
	int result = dao.insert(username,birthyear,addr,mobile);
	
	//7.처리 결과에 따라서 페이지 이동
	if(result>0){//입력이 성공하면
		response.sendRedirect("index.jsp");
	}else{//입력 실패시
		response.sendRedirect("add.jsp");
	}

%>