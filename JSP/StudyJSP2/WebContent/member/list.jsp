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
	<h1>WebContent/member/list.jsp</h1>
	
	<h2>회원목록을 확인 (관리자) </h2>
	<%
		//세션제어(+관리자만 사용) 관리자가 아니면 페이지에서 나가야 한다.
		String id= (String)session.getAttribute("id");
		
		if(id == null || !id.equals("admin")){
			response.sendRedirect("loginForm.jsp");	
		}	
		//DB에서 모든 회원의 정보를 가져와서 처리(테이블에 출력)
		String DRIVER = "com.mysql.jdbc.Driver";
		String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		String DBID = "root";
		String DBPW = "1234";
	
		Class.forName(DRIVER);
		
		Connection conn =
		DriverManager.getConnection(DBURL, DBID, DBPW);
		
		String sql = "select * from itwill_member where id = ?";
		//select * from itwill_member wher id != "admin"; 으로 admin을 아예 빼고 가져오기
		
		PreparedStatement  pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
				
	%>
	
	<%//관리자 정보 빼고 가져오기 
	//1. 디비에서 안가지고 오는 방법  2.while문에서 관리자 데이터를 빼는 방법 
	//1번 방법이 효율적이다.
	%>
	
	<table border="1">
	<tr>
	<td>아이디</td>
	<td>비밀번호</td>
	<td>이름</td>
	<td>나이</td>
	<td>성별</td>
	<td>이메일</td>
	<td>가입일</td>
	</tr>
	
	
	<%while(rs.next()){
		//DB의 데이터를 테이블로 출력
		
		if(rs.getString("id").equals("admin")){
			continue;
		}
				%>
	<tr>
	<td><%=rs.getString("id") %></td>
	<td><%=rs.getString("pw") %></td>
	<td><%=rs.getString("name") %></td>
	<td><%=rs.getInt("age") %></td>
	<td><%=rs.getString("gender") %></td>
	<td><%=rs.getString("email") %></td>
	<td><%=rs.getTimestamp("regdate") %></td>
	</tr>
	<%
	
	} %>
	
	
	</table>
	
	
</body>
</html>