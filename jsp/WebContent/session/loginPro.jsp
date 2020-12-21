<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String userpwd = request.getParameter("userpwd");
	
	//세션영역에 값 담기 => 로그인(아이디,비밀번호,이름)
/* 	session.setAttribute("userid", userid);
	session.setAttribute("userpwd", userpwd); */
	
	
	//객체생성
	LoginDTO login = new LoginDTO(userid, userpwd);
	session.setAttribute("login",login);	
	
	response.sendRedirect("../index.jsp");
%>