<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//deletePro에서 tab값 가져오기:주소값이 넘어오므로 request.getParameter로 받아온다.
	String tab=request.getParameter("tab");
	if (tab == null){
	tab="insert";
}
	
%>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

<script>
//#id값에 주소를 넣으면 시작할때 보여지는 페이지 설정
//tab이 null이면 insert페이지 null이 아니면 delete페이지
$(function(){
	var tab= '<%=tab%>';

	$('#myMenu a[href="#'+tab+'"]').tab('show'); 
	
	$('a[href="#all"]').click(function(){
		location.href="list.do";
	});
});
</script>

</body>
</html>