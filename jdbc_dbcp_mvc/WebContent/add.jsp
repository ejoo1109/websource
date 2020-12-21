<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<div class="container">
<form action="insert.do" method="post">
  <div class="form-group">
    <label for="username">이름</label>
    <input type="text" class="form-control" id="username" name="username" placeholder="이름을 입력하세요" autofocus required>
  </div>
  <div class="form-group">
    <label for="birthyear">태어난 해</label>
    <input type="text" class="form-control" id="birthyear" name="birthyear"placeholder="태어난 년도를 입력하세요" required>
  </div>
    <div class="form-group">
    <label for="addr">주소</label>
    <input type="text" class="form-control" id="addr" name="addr" placeholder="주소를 입력하세요" required>
  </div>
    <div class="form-group">
    <label for="mobile">모바일</label>
    <input type="text" class="form-control" id="mobile" name="mobile" placeholder="핸드폰 번호를 입력하세요" required>
  </div>
  <div class="form-group">
  <button type="submit" class="btn btn-primary">입력</button>
  <button type="reset" class="btn btn-secondary">취소</button>
  </div>
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>

	$("button[type='submit']").click(function(){
		//이름- 한글, 2~4 자리만 가능
		var username = $("#username");
		var regName=/^[가-힣]{2,4}$/;
		if(!regName.test(username.val())) {
				alert("이름을 확인해 주세요");
				username.focus();
				return false;
			 }	
		
		//태어난 해 - 4자리 숫자
		var birthyear = $("#birthyear");
		var regYear = /^\d{4}$/;		
		if(!regYear.test(birthyear.val())) {
				alert("태어난 해를 확인해 주세요");
				birthyear.focus();
				return false;
			 }		
				
		//주소 - 2자리
		var addr = $("#addr");
		var regAddr = /^[A-Za-z가-힣]{2}$/;
		if(!regAddr.test(addr.val())) {
				alert("주소를 확인해 주세요");
				addr.focus();
				return false;
			 }				
		
		//모바일 - 010-1234-1234
		var mobile = $("#mobile");
		var regMobile = /^\d{3}-\d{4}-\d{4}$/;
		if(!mobile.test(regMobile.val())) {
				alert("핸드폰 번호를 확인해 주세요");
				mobile.focus();
				return false;
			 }	
	});
</script>
</body>
</html>