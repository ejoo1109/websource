<%@page import="member.MemberDAO"%>
<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //leaveForm.jsp에서의 값 가져오기
	
	String userid = request.getParameter("userid");
	String current_password = request.getParameter("current_password");
	
	//db작업
	//비밀번호가 맞아서 탈퇴가 되는경우 - 세션해제, index페이지로 이동
		MemberDAO dao = new MemberDAO();
		int result = dao.leaveMember(userid, current_password);
		if(result>0){
			session.invalidate();
			response.sendRedirect("../index.jsp");
			
	}else{	//비밀번호가 틀린경우 - leaveForm.jsp로 이동
		response.sendRedirect("leaveForm.jsp");
	}

%>