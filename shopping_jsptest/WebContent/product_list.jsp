<%@page import="java.util.List"%>
<%@page import="domain.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
	List<ProductVO> list = (List<ProductVO>) request.getAttribute("list");
	if(list==null){
		response.sendRedirect("list.do");
	}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title></title>
</head>
<body>	
<div class="container" style="margin-top: 50px;">
	<h3 class="text-center">상품 리스트</h3>
	<a href="product_write.jsp">상품등록</a>	
	<table class="table table-bordered">
		<thead class="thead-dark text-center">
			<th scope="col">번 호</th>
			<th scope="col">카테고리</th>
			<th scope="col">상품명</th>
			<th scope="col">단 가</th>
			<th scope="col">수 량</th>
			<th scope="col">등록일자</th>
			<th scope="col">추가작업</th>
		</thead>
		<tbody>				
			<!-- 내용 반복 시키는 곳 -->
			<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.num}</td>
				<td>${vo.category}</td>
				<td>${vo.name}</td>
				<td>${vo.price}</td>
				<td>${vo.amount}</td>
				<td>${vo.date}</td>
				<td class="text-center">
					<a href="delete.do?goods_num=${vo.num}">삭제 /</a>
					<a href="modify.do?goods_num=${vo.num}"> 수정</a>
				</td>
			</tr>	
			</c:forEach>			
		</tbody>
	</table>							
</div>				    
</body>	
</html>


