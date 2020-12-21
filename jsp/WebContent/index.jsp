<%@page import="exam.LoginDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	LoginDTO login=(LoginDTO)session.getAttribute("login");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP 테스트 : <%=login.getUserid() %></h1>
	<div>
		<a href="product.jsp">상품페이지</a>
	</div>
</body>
</html>