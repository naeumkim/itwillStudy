<%@page import="java.sql.ResultSet"%>
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
	<h1>WebContent/JSP5/selectTest.jsp</h1>
	
	<%
	//디비에 저장된 모든 회원정보를 출력(콘솔창, 화면)
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	String DBID = "root";
	String DBPW = "1234";
	
	//1.드라이버 로드
	Class.forName(DRIVER);
	//2.디비 연결
	Connection con = 
	DriverManager.getConnection(DBURL, DBID, DBPW);
	System.out.println("디비 연결 성공");
	//3.sql 작성 & pstmt 객체 생성
	String sql = "select * from itwill_member";
	PreparedStatement pstmt = con.prepareStatement(sql);
	//4. sql 구문 실행
	ResultSet rs = pstmt.executeQuery();
	//pstmt.executeQuery();은 조회만 한것이다.
	//sql > bof,컬럼명,데이터,커서,eof(end of file)라는 레코드셋이 생성 맨 처음엔 bof에 커서가 가있다.
	//레코드 셋을 저장시킬 인터페이스가 resultset 이다. 때문에 객체 생성해서  pstmt.executeQuery()넣기
	
	//5.데이터 처리 
	 while(rs.next()){//레코드셋에 데이터가 있으면 T,없으면 F를 리턴하는 메서드(커서이동)
		 //rs.next() > bof다음 즉, 데이터로 커서를 옮기는 메소드 > 한줄만 선택
			//데이터가 있다.
			//rs.getXXXX("컬럼명");
		 	//> 가져오는 컬럼의 데이터 타입에 따라 XXXX는 변경된다.
		 	// > rs객체의 커서가 가리키고 있는 한줄에 데이터 중에서 찾아오는 메서드 
		 	// rs.getString(컬럼인덱스번호) 
		 	// > 인덱스 번호를 사용하는 방법이 훨씬 처리속도가 빠르다.
		 	//while문은 참일때만 반복하기 때문에, 커서를 내려서 데이터가 있을때(true)까지 반복한다. 어떠한 형태든 반복이 가능하다. p.467
		 	//String name = rs.getString("name"); //이름을 꺼내겠다.
		 	
		 	int idx = rs.getInt("idx");
		 	String gender = rs.getString("gender");
		 	int age = rs.getInt("age");
		 	String jumin = rs.getString("jumin");
		 	
		 	String name = rs.getString(2);
		 	out.println("번호 : " + idx + " ");
	 		out.println("사용자 이름 : " + name + " ");
		 	out.println("성별 : " + gender + " ");
		 	out.println("나이 : "+ age + " ");
		 	out.println( "주민번호 : "+ jumin + "<br>");
	 
	 }
	
	 //rs.next() > bof다음 즉, 데이터로 커서를 옮기는 메소드
	System.out.println("회원정보 조회 성공");
	
	
	
	%>
	
	
	
</body>
</html>