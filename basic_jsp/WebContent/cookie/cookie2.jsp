<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키 저장 -객체저장 안됨. 텍스트 형태로 저장가능
	//쿠키생성 Cookie c= new Cookie(name,value)
	//쿠키 저장 response.addCookie(c)
	//쿠키유효시간 설정 가능setMaxAge()
	//쿠키저장
	Cookie c=new Cookie("name","hongkildong");
	//쿠키유효시간 설정 가능
	c.setMaxAge(600); //600초
	//쿠키저장
	response.addCookie(c);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>쿠키 데이터가 저장되었습니다.</h3>
<a href="getCookie2.jsp">쿠키확인</a>
</body>
</html>