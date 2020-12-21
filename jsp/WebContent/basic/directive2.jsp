<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page ErrorPage="error.jsp" %>
<%
	int a=1,b=0;

	out.print(a+b);
	out.print(a-b);
	out.print(a*b);
	out.print(a/b);
%>