<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//지시어 : <%@ include file과 같은개념
 	pageContext.include("pagecontext3.jsp");

%>
<h2>pagecontext.jsp의 forward 메소드로 포워딩된 페이지</h2>
</body>
</html>