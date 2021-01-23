<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//add.jsp에서 사용자 입력값 가져오기
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");
	String birthyear = request.getParameter("birthyear");
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	
	//jdbc ->자바랑 db랑 연동하기 위한 기본 구조
	Connection con=null;
	PreparedStatement pstmt=null; //scope(영역지정) 때문에 파이널에서 자원 닫으려면 try구문 밖으로 지정
	try{ 
		//1.드라이버 로드
		Class.forName("oracle.jdbc.OracleDriver");
		//2.데이터 베이스 연결을 위한 문자열 생성
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="javaDB";
		String password="12345";
		//3.커넥션
		con = DriverManager.getConnection(url, user, password);
		if(con!=null){
		//4.sql구문 생성
		String sql="insert into userTBL values(userTBL_seq.nextval,?,?,?,?)";
		//5.Statement 생성후 전송
		pstmt=con.prepareStatement(sql);
		//?에 해당하는 값을 순번대로 세팅set
		pstmt.setString(1, username);
		pstmt.setInt(2, Integer.parseInt(birthyear));
		pstmt.setString(3, addr);
		pstmt.setString(4, mobile);
		
		//6. sql구문 실행하고 결과 받기
		int result=pstmt.executeUpdate();
		
		//7.처리 결과에 따라서 페이지 이동
		if(result>0){//입력이 성공하면
			response.sendRedirect("index1.jsp");
		}else{//입력 실패시
			response.sendRedirect("add1.jsp");
		}
	}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			pstmt.close();
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
%>