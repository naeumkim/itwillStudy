<%@page import="com.itwillbs.member.Memberbean"%>
<%@page import="java.sql.ResultSet"%>
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
	<h1>WebContent/member/inform.jsp</h1>
	<%
		//로그인한 사람의 정보를 DB에서 조회해서
		//jsp화면에 출력
		//테이블을 만들어 안에 내용 출력	
	
		//로그인 세션처리 (로그인X > 로그인페이지로 이동)
		String id = (String)session.getAttribute("id");
		

		if(id==null){
			System.out.println("[info.jsp] :아이디없음 > 로그인 페이지 이동");
			response.sendRedirect("loginForm.jsp");
		}
			//DB연결 후 필요한 데이터 조회 > 출력
		
		String DRIVER = "com.mysql.jdbc.Driver";
		String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		String DBID = "root";
		String DBPW = "1234";
		
		
		//1드라이버 로드
		Class.forName(DRIVER);
		//2 디비연결
		Connection conn =
		DriverManager.getConnection(DBURL, DBID, DBPW);		
		//3 sql구문 작성(select문) & pstmt 생성
		String sql = "select * from itwill_member where id = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//?
		pstmt.setString(1, id);
		//4 sql객체 실행 > rs에 저장
		
		ResultSet rs = pstmt.executeQuery();
		//5 데이터 처리 
		Memberbean mb = null; 
		if(rs.next()){
			// rs에 저장된 정보를 꺼내서 화면에 출력하고자 한다.
			mb = new Memberbean(); 
			//if문안에 mb가 있기 때문에 지역변수 이다. 밖에서도 쓰려면 전역변수로 만들어주자
			mb.setId(rs.getString("id"));
			mb.setPw(rs.getString("pw"));
			mb.setName(rs.getString("name"));
			mb.setAge(rs.getInt("age"));
			mb.setGender(rs.getString("gender"));
			mb.setEmail(rs.getString("email"));
			mb.setRegdate(rs.getTimestamp("regdate"));
			
			System.out.println("SQL 구문 실행완료!");
			System.out.println(" 저장된 회원정보 :" + mb);
		}
	%>
	
	<table border="1">
	<tr>
		<td>아이디</td>
		<td><%=mb.getId()%></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><%=mb.getPw()%></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=mb.getName()%></td>
	</tr>
	<tr>
		<td>나이</td>
		<td><%=mb.getAge() %></td>
	</tr>
	<tr>
		<td>성별</td>
		<td><%=mb.getGender() %></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><%=mb.getEmail() %></td>
	</tr>
	<tr>
		<td>회원가입일</td>
		<td><%=mb.getRegdate() %></td>
	</tr>
	
	
	</table>
	
	
	<h2><a href='main.jsp'>메인페이지로 이동</a></h2>
	


</body>
</html>