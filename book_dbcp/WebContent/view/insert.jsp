<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- index 시작페이지 기준으로 경로를 잡아야함 -->
<form action="/book_dbcp/view/insertPro.jsp" method="post"> 
	<div class="form-group">
		<label for="code">Code</label> 
		<input type="text" class="form-control" name="code" id="code" required />
	</div>
	<div class="form-group">
		<label for="code">Title</label> 
		<input type="text" class="form-control"	name="title" id="title" required />
	</div>
	<div class="form-group">
		<label for="code">Writer</label> 
		<input type="text" class="form-control"	name="writer" id="writer" required />
	</div>
	<div class="form-group">
		<label for="code">Price</label> 
		<input type="text" class="form-control"	name="price" id="price" required />
	</div>
	<div>
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>
</form>