<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		//1.드라이버 로드
		Class.forName("oracle.jdbc.OracleDriver");
		//2.데이터베이스 연결을 위한 문자열 생성
		String url = "jdbc:oracle:thin:@localhost:1522:orcl";
		String user="javaDB";
		String password="12345";
		//3.커넥션
		Connection con = DriverManager.getConnection(url, user, password);
		if(con!=null){
			out.print("연결되었습니다.");
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
%>