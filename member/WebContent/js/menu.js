/**
 * menu.js 제이쿼리로 이용
 */
$(function(){
	$("#2").detach(); //header.jsp의 번호로 Register 메뉴삭제
	$("#3").detach();//Login 메뉴삭제
	
	var tag="<span class ='navbar-text'>"+name+"님 반갑습니다.</span>";
	tag+="&nbsp;&nbsp;<button type='button' id='modify' class='btn btn-success'>";
	tag+="비밀번호 수정</button>";
	tag+="&nbsp;&nbsp;<button type='button' id='logout' class='btn btn-primary'>";
	tag+="로그아웃</button>";
	tag+="&nbsp;&nbsp;<button type='button' id='leave' class='btn btn-danger'>";
	tag+="회원탈퇴</button>";
	$("#navbarCollapse").append(tag); //navbarCollapse id를 가지고 있는 영역 뒤에 tag붙임
})
