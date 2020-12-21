<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//attributeTest1.jsp 에서 넘긴 값 가져오기
	request.setCharacterEncoding("utf-8");
    String email = request.getParameter("email");
    String address = request.getParameter("address");
    String tel = request.getParameter("tel");
    
    //session 속성에 값 담기
    session.setAttribute("email",email);
    session.setAttribute("address",address);
    session.setAttribute("tel",tel);
    
    //application 속성에 담은 값 가져오기 변수에 담아서 출력하려고 형변환 시킴
    String name = (String)application.getAttribute("name");
%>
<h3><%=name %>님의 정보가 모두 저장되었습니다.</h3>
<a href="attributeTest3.jsp">확인하러 가기</a>
</body>
</html>