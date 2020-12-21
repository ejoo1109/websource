<%@page import="member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../layout/header.jsp" %>
<%
	//로그인 성공시 메세지 띄어주기 위해 loginPro에서 담긴 값 가져오기
	//session영역에 담긴값 가져오기(object타입이므로 형변환해야함)
	
	MemberVO member = (MemberVO)session.getAttribute("login");
	if (member == null){ //로그인 실패시
	

%>
<form class="form-signin" name="loginform" action="loginPro.jsp" method="post">
  <div class="form-label-group">
    <input type="text" id="userid" name="userid" class="form-control" placeholder="id" required autofocus>
    <label for="userid">아이디</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="current_password" name="current_password" class="form-control" placeholder="Password" required>
    <label for="pass">비밀번호</label>
  </div>

  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> Remember me
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  <p class="mt-5 mb-3 text-muted text-center">&copy; 2019</p>
</form>
<%}else{ //로그인 성공시 상단 메뉴바2개 안보이게 하고 우측에 버튼3개 만들기 menu.js페이지만들고 붙이기 %>
	<script>
		var name='<%=member.getName()%>';
	</script>
	<script src="../js/menu.js"></script>
<%
	}
%>
<script src="../js/command.js"></script>
<%@ include file="../layout/footer.jsp" %>