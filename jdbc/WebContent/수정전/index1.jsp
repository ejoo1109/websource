<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	try{
		//1.드라이버 로드
		Class.forName("oracle.jdbc.OracleDriver");
		//2.데이터베이스 연결을 위한 문자열 생성
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user="javaDB";
		String password="12345";
		//3.커넥션
		Connection con = DriverManager.getConnection(url, user, password);
		//4.sql 구문 생성
		if(con!=null){
			String sql = "select * from userTBL";
		//5.Statement 생성 후 전송: DB연결을 통해 sql문을 수행해 주는 클래스
			PreparedStatement pstmt= con.prepareStatement(sql);
		//6.sql 구문 실행 하고 결과 받기 
		//select 구문 executeQuery() => ResultSet,
		//insert,update,delete 구문 excuteUpdate()=> int로 돌려줌
			ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<style>
	.container{
	margin-top: 30px;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">JDBC</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
				<a class="nav-link" href="index.jsp">User 조회 
				<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item">
				<a class="nav-link" href="add.jsp">User 추가</a></li>
				<li class="nav-item">
				<a class="nav-link" href="update.jsp">User 수정</a></li>
				<li class="nav-item">
				<a class="nav-link" href="delete.jsp">User 삭제</a></li>
			</ul>
		</div>
	</nav><!-- nav 종료 -->
<div class="container">
	<table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">이름</th>
      <th scope="col">태어난 해</th>
      <th scope="col">주소</th>
      <th scope="col">모바일</th>
    </tr>
  </thead>
  <tbody>
 <%
	//7.결과를 출력 (ResultSet : DB Select 결과를 담는 특수한 테이블구조 객체)
		//resultset은 바로 출력이 안됨 db테이블 열 순번(타입)으로 지정해서 가져오기
		while (rs.next()){
			int no = rs.getInt(1);	//no(number)
			String userName = rs.getString(2); //username(nchar)
			int birthYear = rs.getInt(3); //birthYear(number)
			String addr = rs.getString(4); //addr(nchar)
			String mobile = rs.getString(5); //mobile(nvarchar2)
			//System.out.println(no+"\t"+userName+"\t"+birthYear+"\t"+addr+"\t"+mobile);
	//DB에 있는 목록들 하나씩 꺼내오면서 tr,td붙이기
%>
	<tr>
		<td><%=no %></td>
		<td><a href="select.jsp?no=<%=no%>"><%=userName %></a></td>
		<td><%=birthYear %></td>
		<td><%=addr %></td>
		<td><%=mobile%></td>		
	</tr>
<% 
		}//while
	}//if
}catch(Exception e){
		e.printStackTrace();
}
 %>
  </tbody>
</table>
</div>
</body>
</html>