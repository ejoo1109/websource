<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../LoginServelt" method="post">
		<div>
			<label for="userid">아이디</label>
			<input type="text" name="userid" id="userid" />
		</div>
		<div>
			<label for="userpwd">비밀번호</label>
			<input type="password" name="userpwd" id="userpwd" />
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>