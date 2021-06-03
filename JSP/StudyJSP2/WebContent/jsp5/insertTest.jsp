<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
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
	<h1>WebContent/jsp5/insertTest.jsp</h1>
	<%
	
	String name ="itwillll";
	String gender= "여"; 
	int age = 30;
	String jumin = "900101-123131";
	
	final String DRIVER = "com.mysql.jdbc.Driver";
	final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	final String DBID = "root";
	final String DBPW = "1234";
	
	// 1단계 드라이버 로드
	Class.forName(DRIVER);
	
	System.out.println("드라이버 로드 성공!");
	
	// 2단계 디비 연결
	Connection conn = 
	DriverManager.getConnection(DBURL, DBID, DBPW);//연결정보 가져오기
	
	System.out.println("디비 연결 성공 :" + conn);
	
	System.out.println("디비연결완료 SQL쿼리 사용전 준비 상태");
	//매니저,커넥션은 java.sql.DriverManager
	
	//3단계 sql구문 작성 & statement 객체 생성(>preparedstatement 변경예정)
	 //String sql = 
	 //"insert into itwill_member (name, gender,age, jumin) values ('테스트','남',10,'900110-1111111')";
	
	// String sql 
	//	= "insert into itwill_member (name, gender,age, jumin) values ('" +name+ "','" +gender+ "','" +age+ "','" +jumin+ "')";
	
	 String sql 
	= "insert into itwill_member (name, gender,age, jumin) values (?,?,?,?)";
	//> 컬럼과 ?의 개수 동일하게 해주기 	
	
	
	//Statement : SQL구문을 실행하는 객체
	//PreparedStatement : SQL구문을 실행하는 객체 
	//> 미리 쿼리 구문을 가지고 생성 = 쿼리문을 실행할 준비가 되어있는 상태(처리속도 우수,보안상 안정)
	//Statement stmt = conn.createStatement(); //객체만 생성
	
	
	
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	//java.sql 인터페이스 PreparedStatement 사용
	//sql구문을 가지고 가서 생성, 미리 실행할 준비
	
	//?를 채워야한다
	//
	//pstmt.setXXXXX(?위치, 저장할 값)
	//XXXXX는 컬럼의 데이터 타입에 따라서 변경된다.
		//내가 넣고자하는 타입으로 설정 됨, 위는 name...이므로 setString 으로 생성
	pstmt.setString(1, name);
	//1번째 물음표에 name변수를 넣겠다.
	pstmt.setString(2, gender);
	pstmt.setInt(3, age);
	pstmt.setString(4, jumin);

	
	//4단계 SQL구문을 실행
	//stmt.executeUpdate(sql);
	
	//실행할때마다 쓰는 메소드가 다르다.
	//pstmt.executeUpdate();
	//>insert,update,delete 구문 실행 시 사용 
	//>db의 데이터를 조작하는 구문들
	
	//pstmt.executeQuery();
	//>select 구문 실행시 
	//>값이 바뀌지 않는 구문
	
	
	pstmt.executeUpdate();
	//sql구문을 가져왔기 때문에 ()안에 sql을 적지 않아도됨.
	System.out.println("디비 정보 저장완료!");
	
	
	
	%>
	
</body>
</html>