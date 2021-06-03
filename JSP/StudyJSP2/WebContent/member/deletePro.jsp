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
	<h1>WebContent/member/deletePro.jsp</h1>
	
	<%
	String id = (String)session.getAttribute("id");
	if(id == null){
		response.sendRedirect("loginForm.jsp");
		
	}
	//한글처리
	request.setCharacterEncoding("UTF-8");
	
	
	//전달되는 정보 저장
	%>
	
	<jsp:useBean id="mb" class="com.itwillbs.member.Memberbean"></jsp:useBean>
	
	<jsp:setProperty property="*" name="mb"/>
	
	
	<%
	System.out.println("삭제회원정보 : " + mb);
	//삭제, 업데이트는 본인확인을 거친 후 삭제, 수정할 수 있도록 로직을 설계 해야함
	
	
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	String DBID = "root";
	String DBPW = "1234";
	
	//1드라이버 로드
	Class.forName(DRIVER);
	//2 디비연결
	Connection conn =
	DriverManager.getConnection(DBURL, DBID, DBPW);
	
	// sql 구문 실행
	String sql = "select pw from itwill_member where id= ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	//?
	pstmt.setString(1, mb.getId());
	//데이터 처리	
	ResultSet rs = pstmt.executeQuery();
	
	if(rs.next()){
	
		if(mb.getPw().equals(rs.getString("pw"))){
			//sql구문 작성
			sql = "delete from itwill_member where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mb.getId());
			
			pstmt.executeUpdate();
		
			//세션정보 초기화
			session.invalidate();
			
			//메인페이지로 이동
			response.sendRedirect("main.jsp");
		
		}else{
		%>
		<script type="text/javascript">
		alert("비밀번호 같지 않음");
		history.back();
		</script>
		<%
		}
	
	}else{
		%>
		<script type="text/javascript">
		alert("아이디 없음");
		history.back();
		</script>
		<%
		
	}
	%>
	
	
</body>
</html>