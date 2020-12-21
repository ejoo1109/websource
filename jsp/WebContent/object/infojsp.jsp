<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String password1 = request.getParameter("password1");
	String password2 = request.getParameter("password2");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입정보 입력 확인</title>
</head>
<body>
		<ul>
		<li>이름 : <%=name %></li>
		<li>아이디 : <%=id%> </li>
		<li>비밀번호: <%=password1%></li>
		<li>비밀번호확인: <%=password2%></li>
		<li>성별 : <%=gender%></li>
		<li>이메일 : <%=email%></li>
		</ul>
</body>
</html>