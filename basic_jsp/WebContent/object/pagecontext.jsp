<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% //내장객체 - pageContext : 다른 내장객체를 얻어내거나 현재 페이지의 요청과
  //            응답의 제어권을 다른 곳으로 넘길 때 사용
  //중요메소드 - forward(), include()
  
  pageContext.forward("pagecontext2.jsp");

%>
</body>
</html>
<!-- paga3을 포함하는 page2한테 포워드시킴 -->