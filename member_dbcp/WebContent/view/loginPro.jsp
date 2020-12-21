<%@page import="member.MemberVO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//loginForm.jsp 에서 넘긴값 가져오기
	request.setCharacterEncoding("utf-8");
	String userid = request.getParameter("userid");
	String password = request.getParameter("current_password");
	
	//db작업하기 isLogin 반환타입이 MemberVo타입이므로 형변환을 해야한다.
	MemberDAO dao = new MemberDAO();
	MemberVO member= dao.isLogin(userid,password);
	
	//loginForm으로 이동
	if (member!=null){//로그인 작업: 현재정보를 session에 담기
		session.setAttribute("login",member);
	}else{
		out.print("<script>alert('아이디와 비밀번호를 확인해 주세요');</script>");	
	}
	//response.sendRedirect("loginForm.jsp"); 또는 location.href사용
	out.print("<script>");
	out.print("location.href='loginForm.jsp';");
	out.print("</script>");
%>