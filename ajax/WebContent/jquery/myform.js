/**
 * 
 */
 $(function(){
 	$("#post").click(function(){
 		//보낼 데이터 가져오기
		let id = $("#id").val();
		let age = $("#age").val();
 	
 		$.ajax({
 			type:"post",
 			url:"sendForm.jsp",
 			data:{
 				id:id,
 				age:age
 			},
 			success:function(data){
 				$("#ajaxReturn").html(data);
 			},
 			error:function(xhr,txtStatus,error){
 				alert("error");
 			}
 		}) 	
 	 });
 });
