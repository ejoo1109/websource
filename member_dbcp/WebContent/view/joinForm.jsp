<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<div class="container" style="margin-top:40px">
<form id="joinform" action="joinPro.jsp" method="post">
	<div class="form-group row justify-content-center">
		<label for="userid" class="col-sm-2 col-form-label">아이디</label>
		<div class="col-sm-6">
			<input type="text" name="userid" id="userid" class="form-control" placeholder="아이디를 입력하세요" onchange="dupId()"/>
			 <small id="userid" class="text-info"></small>
		</div>
	</div>
	<div class="form-group row justify-content-center">
		<label for="pass1" class="col-sm-2 col-form-label">비밀번호</label>
		<div class="col-sm-6">
			<input type="password" name="password" id = "password" class="form-control" placeholder="비밀번호를 입력하세요"/>
			<small id="password" class="text-info"></small>
		</div>
	</div>
	<div class="form-group row justify-content-center">
		<label for="pass2" class="col-sm-2 col-form-label">비밀번호 확인 </label>
		<div class="col-sm-6">
			<input type="password" name="confirm_password" id = "confirm_password" class="form-control" placeholder="비밀번호를 다시 입력하세요"/>
			<small id="confirm_password" class="text-info"></small>
		</div>
	</div>
	<div class="form-group row justify-content-center">
		<label for="name" class="col-sm-2 col-form-label">이름 </label>
		<div class="col-sm-6">
			<input type="text" name="name" id="name" class="form-control" placeholder="이름을 입력하세요"/>
			<small id="name" class="text-info"></small>
		</div>
	</div>
	<div class="form-group row justify-content-center">
	<label for="pass2" class="col-sm-2 col-form-label">성별 </label>
	  <div class="col-sm-6">
			<div class="form-check form-check-inline">
				<input type="radio" id="gender" name="gender" value="남" class="form-check-input"/>남
		  	</div>
		  	<div class="form-check form-check-inline">
				<input type="radio"  name="gender" value="여" class="form-check-input"/>여
			</div>
			<small id="gender" class="text-info"></small>
		</div>
	</div>
	<div class="form-group row justify-content-center">
		<label for = "email" class="col-sm-2 col-form-label">이메일</label>
		<div class="col-sm-6">
			<input type="email" name="email" id="email" class="form-control" placeholder="example@gmail.com"/>
			<small id="email" class="text-info"></small>
		</div>
	</div>
	<div class="form-group text-center">
		<button type="submit" class="btn btn-primary">입력</button>
	    <button type="reset" class="btn btn-secondary">취소</button>
	</div>
</form>
</div>
<script>
function dupId(){
	//사용자가 입력한 userid 가져와서 서버로 보내기
	var userid = $("#userid").val();
	console.log(userid);
	$.ajax({
		url:"checkId.jsp",
		type:"post",
		data:{
			userid:userid
		},
		success:function(data){
			if($.trim(data)=="true"){//동일아이디가 있다면 true
				alert("아이디는 사용 불가");
			}else{
				alert("아이디는 사용 가능");
			}
		}
	})
	
}
</script>
<%-- 사용자 validate 코드 삽입하기 --%>
<script src="../js/join.js"></script>
<%@include file="../layout/footer.jsp" %>
