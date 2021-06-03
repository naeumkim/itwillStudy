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
	<h1>WebContent/member/updatePro.jsp</h1>
	
	<%
	
	//로그인 세션
	 
	String id = (String)session.getAttribute("id");
	
	if(id == null){
		System.out.println("[UpdatePro.jsp] :  아이디 없음 > 로그인 페이지로 이동");
		response.sendRedirect("loginForm.jsp");
	}
	
	//한글처리
	request.setCharacterEncoding("UTF-8");
	
	//전달되는 정보를 저장 >  액션태그 사용시 자바빈 객체에 저장
	//MemberBean 객체 사용
	
	%>
	
	<jsp:useBean id="mb" class ="com.itwillbs.member.Memberbean"></jsp:useBean>	
	
	<jsp:setProperty property="*" name="mb"/>
	<!-- 멤버빈에 있는 모든 객체를 가져 와 프로퍼티에 넣는다. -->
	
	
	<% 
	System.out.println("전달될 수정정보 : " + mb);
	//DB접속 후 정보 확인하고 나서 해당데이터 수정
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	String DBID = "root";
	String DBPW = "1234";
	
	Class.forName(DRIVER);
	System.out.println("드라이버 로드 성공");

	
	Connection conn =
	DriverManager.getConnection(DBURL, DBID, DBPW);
	
	//sql 작성 
	//본인여부를 확인 후 수정여부를 결정
	String sql = "select pw from itwill_member where id= ?";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	
	//pstmt.setString(1, id);
	pstmt.setString(1, mb.getId());
	
	//sql 실행
	ResultSet rs = pstmt.executeQuery();
	
	//5 데이터 처리
	
	if(rs.next()){
		//아이디가 있는 경우
		if(mb.getPw().equals(rs.getString("pw"))){
			//비밀번호 같음 >  본인 > 정보수정
			
			//위에서 드라이버 로드를 완료 했으므로 3 sql구문 생성 부터 하면 된다
			sql = "update itwill_member set name=?,age=?,gender=?,email=? where id=?";
			pstmt = conn.prepareStatement(sql);
			//4 sql실행
			
			pstmt.setString(1, mb.getName());			
			pstmt.setInt(2, mb.getAge());			
			pstmt.setString(3, mb.getGender());			
			pstmt.setString(4, mb.getEmail());			
			pstmt.setString(5, mb.getId());			
			
			pstmt.executeUpdate();
			
			
			response.sendRedirect("main.jsp");
			}else{
				//비밀번호 다름 > 오류 > 페이지 뒤로 이동
				%>
				<script type="text/javascript">
				alert("비밀번호 오류!");
				history.back();
				</script>
				
				<%
				
				 }
			
		
		
		
		}else{
		//아이디가 없는경우 > 오류 > 페이지 뒤로 이동
			%>
			<script type="text/javascript">
			alert("아이디 없음!");
			history.back();
			</script>
			
			<%
	}
	
	
	//정상적인 수정 후 , main.jsp 페이지 이동
		//문제 발생시 페이지 뒤로가기
	
	%>
</body>
</html>