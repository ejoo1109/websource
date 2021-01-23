<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %> <!-- 에러페이지를 포함하고 있음 -->
<%
	int a=1,b=0;

	out.print(a+b);
	out.print(a-b);
	out.print(a*b);
	out.print(a/b);
%>