<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>include 액션 테스트</h2>
<!-- pageContext.include();와 같은개념 --> <!-- 하단에 includeTest2.jsp 내용이 포함된다.(제어권 이동x)  -->
<jsp:include page="includeTest2.jsp"/>
</body>
</html>