<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fileName = request.getParameter("fileName");
	
	//다운로드가 일어날 폴더지정
	String downPath = "c:\\upload";
	String filePath = downPath+"\\"+fileName;
	
	FileInputStream in = new FileInputStream(filePath);
	
	//jsp는 이미 out객체가 있는데 response.getOutputStream() 중복사용으로 콘솔창에 에러표시
	//열려있는 out객체 닫음
	out.clear();
	out=pageContext.pushBody();
	
	//response 헤더 설정,브라우저 헤더에 이름을 붙인다.
	response.setContentType("application/octet-stream");
	//파일명 한글안깨지게 설정
	fileName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
	//response.setHeader("Content-Disposition", "attachment;filename="+fileName);
	//다운로드시 uuid값_실제파일명
	// _ 기준으로 잘라서 파일명 붙여주기
	//String oriName = fileName.substring(fileName.lastIndexOf("_")+1);
	String oriName = fileName.substring(fileName.indexOf("_")+1);
	response.setHeader("Content-Disposition", "attachment;filename="+oriName);
	
	//다운로드하고 파일저장하기 위해 사용
	BufferedOutputStream buf = new BufferedOutputStream(response.getOutputStream());
	
	int numRead=0;
	byte[] b=new byte[8192];
	while((numRead=in.read(b,0,b.length)) != -1){
		buf.write(b,0,numRead);
	}
	
	//버퍼 비우기
	buf.flush();
	//자원닫기
	buf.close();
	in.close();


%>