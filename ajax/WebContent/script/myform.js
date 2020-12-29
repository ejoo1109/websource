/**
 * 
 */
function getSend(){
	//보낼 데이터 가져오기
	let id = document.getElementById("id").value;
	let age = document.getElementById("age").value;
	
	let httpRequest = new XMLHttpRequest();
	httpRequest.open('GET','getAjax.jsp?id='+id+'&age='+age);
	httpRequest.send();
	
}
function postSend(){
		//보낼 데이터 가져오기
	let id = document.getElementById("id").value;
	let age = document.getElementById("age").value;
	
	let httpRequest = new XMLHttpRequest();
	httpRequest.open('POST','getAjax.jsp');
	httpRequest.setRequestHeader('Content-type','application/x-www-from-urlencoded');
	httpRequest.send('id='+id+'&age='+age);
}