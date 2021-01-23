<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forwardTest1</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<%--jsp 액션 태그 :자바코드 노출 최소화 --%>
<%-- pageContext.forward();랑 같은 개념 --%>
<%--param : 옵션 --%>

<jsp:forward page='<%=request.getParameter("forwardPage") %>'>
	<jsp:param value="034-1234-5678" name="tel"/>
</jsp:forward>


<!-- info.html 페이지실행시 forwardTest1이 포워드된 forwardTest2가 실행된다.(제어권 이동) -->

</body>
</html>