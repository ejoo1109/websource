<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int num1=Integer.parseInt(request.getParameter("num1"));
int num2=Integer.parseInt(request.getParameter("num2"));

int sum = num1 + num2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>덧셈프로그램</title>
</head>
<body>
<h2>덧셈결과</h2>
<h3>
<%  out.print(+num1+"+"+num2+"="+sum);
%>
</h3>
</body>
</html>