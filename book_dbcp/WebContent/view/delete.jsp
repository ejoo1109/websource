<%@page import="book1.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="/book_dbcp/view/deletePro.jsp" method="post">
<h4>삭제할 책의 코드 번호를 입력하세요</h4>
	<div class="form-group">
		<label for="code">Code</label> 
		<input type="text" class="form-control" name="code" id="code" required />
	</div>
	<div>
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>
</form>
