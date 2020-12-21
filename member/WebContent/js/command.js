/**
 * menu-버튼 클릭하면 페이지이동
 */
$(function(){
	//logout클릭시 logoutPro.jsp로 이동
	$("#logout").click(function(){
		location.href='logoutPro.jsp';
	})
	
})
$(function(){
	//비밀번호 버튼 클릭시 modifyForm.jsp로 이동
	$("#modify").click(function(){
		location.href='modifyForm.jsp';
	})
	
	$("#leave").click(function(){
	location.href='leaveForm.jsp';
	})
})
