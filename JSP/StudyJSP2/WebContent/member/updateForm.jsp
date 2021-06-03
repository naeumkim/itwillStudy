<%@page import="com.itwillbs.member.Memberbean"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/member/updateForm.jsp</h1>
	
	<h2>회원 정보 수정</h2>
	
	<%
	String id = (String)session.getAttribute("id");
	
	if(id==null){
		System.out.println("[info.jsp] :아이디없음 > 로그인 페이지 이동");
		response.sendRedirect("loginForm.jsp");
	}
	
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	String DBID = "root";
	String DBPW = "1234";
	
	Class.forName(DRIVER);
	
	Connection conn =
	DriverManager.getConnection(DBURL, DBID, DBPW);
	
	
	String sql = "select * from itwill_member where id = ?";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, id);
	
	ResultSet rs =
	pstmt.executeQuery();
	
	Memberbean mb = null;
	
	if(rs.next()){
		mb = new Memberbean();
		mb.setId(rs.getString("id"));
		mb.setPw(rs.getString("pw"));
		mb.setName(rs.getString("name"));
		mb.setAge(rs.getInt("age"));
		mb.setGender(rs.getString("gender"));
		mb.setEmail(rs.getString("email"));
		mb.setRegdate(rs.getTimestamp("regdate"));
		
		
	}
	
	
	%>
	
	<%if(mb != null){ //오류 걸리는 경우가 있음, 세션이 없어서 오류가 걸림 이를 방지하기 위해 if문으로 form 묶기%>
	<fieldset>
	<legend>아이티윌 회원 정보 수정 페이지</legend>
	<form action="updatePro.jsp" method="post">
	아이디 : <input type="text" name = "id" value="<%=mb.getId()%>" readonly="readonly"> <br>
	<%/*input태그 
	readonly속성 : 값을 변경X, 데이터 전송(submit) o 
	disabled속성 : 값을 변경X, 데이터 전송(submit) x
	*/%>
	비밀번호 : <input type="password" name = "pw" value="<%=mb.getPw()%>" 
	placeholder="비밀번호를 입력하세요"> <br>
	<hr>
	이름 : <input type="text" name = "name" value="<%=mb.getName()%>"> <br>
	나이 : <input type="number" name = "age" value="<%=mb.getAge()%>"> <br>
	성별 : <input type="radio" name = "gender" value= "남"
	<%if(mb.getGender().equals("남")){
		%>checked="checked" <% 
	} %>
	> 남 
	<input type="radio" name = "gender" value="여"
	<%if(mb.getGender().equals("여")){
		%>checked="checked" <% 
	} %>
	> 여 <br>
	이메일 : <input type="email" name = "email" value="<%=mb.getEmail()%>"> <br>
	<br>
	<input type = "submit" value = "수정하기">

	</form>
	<%} %>
	</fieldset>
	
	

</body>
</html>