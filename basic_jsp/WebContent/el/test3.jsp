<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL에서 사용하는 연산자</h1>
${1 > (4/2)} <br/>
${4.0 >= 3} <br/>
${10.0 == 10.0} <br/>
${10.0 eq 10.0} <br/>
${10.0 != 10.0} <br/>
<!-- ${10.0 ne 10.0} <br/> 문법상 맞지만 이클립스에서 error로 표시 -->
<h1>EL + JSTL</h1>
<c:if test="${5<10}"> <%--else 개념이 없음. if나 태그 사용가능 --%>
	<h3>5는 10보다 작다</h3>
</c:if>
<c:choose>
	<c:when test="${5+10==50}"> <%--if-else개념을 사용하고 싶으면 c:choose when,otherwise 를 사용한다. --%>
		<h3>5+10은 50이다</h3>
	</c:when>
	<c:otherwise>
		<h3>5+10은 50이 아니다</h3>
	</c:otherwise>
</c:choose>
</body>
</html>