<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP5/deletepro.jsp</h1>
	
	<%
	//한글처리
	//데이터를 전달받아서 처리(파라미터)
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	
	//드라이버 로드
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root"; 
	final String DBPW =  "1234";

	Class.forName(DRIVER);
	System.out.println("드라이버 로드 성공");
	
	//디비연결
	Connection con = 
	DriverManager.getConnection(DBURL, DBID, DBPW);
	System.out.println("디비 연결 성공");
	
	//sql 작성
	String sql = "delete from itwill_member where id =? and pw=?";
	//pstmt객체 생성
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	pstmt.setString(1, id);
	pstmt.setString(2, pw);
	
	//sql 실행
	pstmt.executeUpdate();
	System.out.println("삭제 완료");
	
	%>
	
	
</body>
</html>