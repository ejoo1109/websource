<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //사용자가 입력한 값 가져오기
 	String username=request.getParameter("username");   
    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>당신의 이름은 <%=username %>입니다.</h4>
</body>
</html>