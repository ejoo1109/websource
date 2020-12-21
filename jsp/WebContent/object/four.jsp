<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%

	int num1=Integer.parseInt(request.getParameter("num1"));
	int num2=Integer.parseInt(request.getParameter("num2"));
	String op=request.getParameter("op");
	int result=0;
	
	switch(op) {
	case "+":
		result=num1+num2;
		break;
	case "-" :
		result=num1-num2;
	    break;		    
	case "*" :
		result=num1*num2;
		break;			
	case "/" :
		result=num1/num2;
		break;
	default:
		break;
	}
	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사칙연산 프로그램</title>
</head>
<body>

		 <h2>사칙연산 결과</h2>
		 <h3><%=num1 %><%=op %><%=num2 %>=<%=result %></h3>
</body>
</html>