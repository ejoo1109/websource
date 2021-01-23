<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//update.jsp에서 넘긴값 가져와서(no,addr,mobile) 수정 후 
	//성공하면 index.jsp로 이동
	// update 테이블명 set addr=수정값, mobile=수정값 where no=12
	request.setCharacterEncoding("utf-8");
	int no = Integer.parseInt(request.getParameter("no"));
	String addr = request.getParameter("addr");
	String mobile = request.getParameter("mobile");
	Connection con=null;
	PreparedStatement pstmt=null;
	try{ 
		Class.forName("oracle.jdbc.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="javaDB";
		String password="12345";
		con = DriverManager.getConnection(url, user, password);
		if(con!=null){
			String sql="update userTBL set addr=?, mobile=? where no=?";
			//? 세팅하기 순서대로!!!
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, mobile);
			pstmt.setInt(3, no);
			int result=pstmt.executeUpdate();
			
			if(result>0){
				response.sendRedirect("index1.jsp");
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