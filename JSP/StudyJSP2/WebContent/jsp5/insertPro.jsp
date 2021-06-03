<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/JSP5/insertPro.jsp</h1>
	
	<%
	//이전 페이지에서 전달된 데이터 저장 > 콘솔 출력
	//post방식으로 전달하면 인코딩 필요
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	
	
	System.out.println("전달 정보 : " + id +"/" + pw + "/" + email);
	
	
	//전달받은 데이터 DB에 저장
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	String DBID = "root";
	String DBPW = "1234";
	
	
	//1.드라이버 로드
	Class.forName(DRIVER);
	System.out.println("드라이버 로드 성공!");
	//2.디비 연결
	Connection con = 
	DriverManager.getConnection(DBURL, DBID, DBPW);
	System.out.println("디비연결 성공!");
	//3. sql구문 작성 & pstmt 객체 생성
	String sql = "insert into itwill_member (id,pw,email) values(?,?,?)";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	// ? 추가
	pstmt.setString(1, id);	
	pstmt.setString(2, pw);	
	pstmt.setString(3, email);	
	//pstmt.setString(3,request.getParameter("email"));	
	//pro 페이지에서 바로 실행하면 값이 null이기 때문에(not null조건) 오류가 뜬다. 
	//> null이 안뜨게 하기 위해 입력해야  pro 페이지로 넘어갈 수 있도록 설정 해줘야 한다.		
	//4.sql 실행
	pstmt.executeUpdate();
	System.out.println("드라이버 로드 성공!");
	%>
	

</body>
</html>