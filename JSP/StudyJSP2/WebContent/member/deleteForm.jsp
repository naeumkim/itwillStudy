<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/member/deleteForm.jsp</h1>
	
	<%
		//세션제어 (로그인 유무를 판단해서 지울지 말지 결정할 수 있음)
		String id = (String)session.getAttribute("id");
		
		if(id==null){
			response.sendRedirect("loginForm.jsp");
		}	
	
		//아이디/ 비밀번호를 입력받아서 정보를 삭제처리하는 페이지로 전달
		
	%>
	
	<h2>회원 탈퇴(삭제)</h2>
	
	<form action="deletePro.jsp" method="post">
	<%--아이디 : <input type="text" name="id" value="<%=id%>" readonly="readonly"> <br>
	hidden기능을 이용해 데이터는 전달하되, 화면에는 보이지 않게 한다. 
	--%>
	<input type ="hidden" name="id" value="<%=id%>">
	비밀번호 : <input type="password" name="pw">
	<hr>
	<input type ="submit" value = "삭제하기">
	</form>
	
</body>
</html>