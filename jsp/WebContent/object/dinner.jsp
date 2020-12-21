<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String[] dinners=request.getParameterValues("dinner");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택지</title>
</head>
<body>
	<h3>오늘의 저녁 메뉴</h3>
	<ul>
	<% 
			for(String s:dinners) {
				out.print("<li>"+s+"</li>");
			}

	%>
	</ul>
</body>
</html>