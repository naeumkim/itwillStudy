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
	<h1>WebContent/member/loginPro/jsp</h1>
	
	<%
	//한글처리
	request.setCharacterEncoding("UTF-8");
	//전달정보를 저장 (자바빈 객체 - 액션태그) id, pw
	%>
	<jsp:useBean id="mb" class="com.itwillbs.member.Memberbean"></jsp:useBean>
	
	<jsp:setProperty property="*" name="mb"/>
	
	<%
	System.out.println("전달 정보 : " + mb);
	///////////////////////////////////////////
	//DB이동 후 로그인 상태 판별
	
	//디비연결 필요정보
	String DRIVER = "com.mysql.jdbc.Driver";
	String DBURL = "jdbc:mysql://localhost:3306/jspdb";
	String DBID = "root";
	String DBPW = "1234";
	
	
	//1. 드라이버 로드
	Class.forName(DRIVER);
	System.out.println("드라이버 로드 성공");
	
	//2.디비연결
	Connection conn
	= DriverManager.getConnection(DBURL, DBID, DBPW);
	
	// sql 구문 작성 & pstmt
	String sql 
	= "select pw from itwill_member where id=?";
	
	PreparedStatement pstmt = conn.prepareStatement(sql);
	//id가 존재하지 않아, pw가 없을때 커서도 없다.
		//>데이터가 있으면 커서가 있다.
	//id는 pk, pw는 not null
	
	
	//?
	pstmt.setString(1, mb.getId());
	
	//4 sql 구문 실행
	ResultSet rs = 
	pstmt.executeQuery();
	
	//5데이터 처리
	
	if(rs.next()){ //sql 구문의 결과가 있을때
		//회원이다.
		//비밀번호를 사용해서 본인확인
		if(mb.getPw().equals(rs.getString("pw"))){
			//값을 비교할때는 String타입으로 비교하면 X Equals 써줘야함
			//비밀번호 같다. (회원이다) > 로그인 성공
			
			//로그인 성공의 의미로 회원 ID정보를  session 내장객체에 저장
			session.setAttribute("id", mb.getId());
			//mb.getId()은 String타입의 데이터, 원래는 object를 담아야한다. 업캐스팅이 돼서 들어가게간다. 
			
			
			//main.jsp 페이지 이동 
			//response.sendRedirect("main.jsp");
			
			//스크립트와 jsp 같이 사용 X 출력순서가 다르기때문에 오류가 뜨므로 주의
			%>
			<script type="text/javascript">
			alert("로그인 성공");
			location.href = "main.jsp";
			</script>
			<%
					
		}else{//비밀번호 다름 (+회원이다)
			%>
			<script type="text/javascript">
			alert("비밀번호가 다릅니다.");
			history.back();			
			</script>
			<%
		}
		
	}else{
		
		%>
		<script type="text/javascript">
		
		//confirm("비회원 입니다. 회원가입 하시겠습니까?")
		//Y - 회원가입 페이지 이동, N - 페이지 뒤로 가기
		var result = confirm("비회원 입니다. 회원가입하시겠습니까?");
		if(result){
			location.href="insertForm.jsp";
			
		}else{
		
		history.back();			
		}
		</script>
		<%
		
	}
	%>
</body>
</html>