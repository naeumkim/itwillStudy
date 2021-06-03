
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContene/member/main.jsp</h1>
	
	<%
	//사용자가 로그인을 했을때만, main 페이지 확인 가능
	//로그인을 하지 않았을 경우, 로그인 페이지로 이동시키기
	
	//로그인 프로 페이지에서 로그인을 성공하면 세션 회원 ID정보를  session 내장객체에 저장 했었음
	//session.setAttribute("id", mb.getId());
	
	//세션객체의 정보를 가져와서 확인
	String id = (String)session.getAttribute("id");
	//session.getAttribute("id"); 가 오브젝트이므로 String으로 다운캐스팅(앞에서 업캐스팅이 됐음)
	
	if(id == null){
		//로그인을 하지 않았다는 뜻 > 로그인 페이지로 보내기
		System.out.println("[main.jsp] : 아이디 없음 > 로그인 페이지로 이동");
		response.sendRedirect("loginForm.jsp");
		
	}
	%>
	
	
	<h2><%=id %>님 환영합니다~!</h2>
	
	
	<input type = "button" value="로그아웃" onclick="location.href='logout.jsp'">
	
	
	<hr>
	
	<h3><a href="inform.jsp">회원정보 조회</a></h3>
	
	
	<h3><a href="updateForm.jsp">회원정보 수정</a></h3>
	
	
	<h3><a href="deleteForm.jsp">회원정보 탈퇴(삭제)</a></h3>
	
	<!-- 관리자만 사용가능한 메뉴 생성 -->
		<%
		//id가 null이라서 오류가 발생함, id가 null이 아니면서, admin이여야 볼 수 있다의 로직으로 바꿔야한다.
		
		
		//nullpoint exception의 오류를 피하기 위해 작성
		//if(id != null){ 
			//주의 둘 조건의 순서를 바꾸면 안된다. null인거 먼저 확인하고 > admin인지 확인해야함 
			//admin조건을 먼저 수행하면 null값일때 비교 자체가 안되면서 nullpoint exception의 오류가 발생한다.
			
			//참조형 데이터 값 비교시 항상 null값을 먼저 비교후 데이터를 비교해야한다.
			if(id != null && id.equals("admin")){%>
			
			<h3><a href="list.jsp">회원 목록보기</a></h3>
		<%	
		}	
		//}
		%>
	
</body>
</html>