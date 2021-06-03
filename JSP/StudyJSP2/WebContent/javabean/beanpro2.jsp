<%@page import="com.itwillbs.beantest.Javabean2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/javabean/beanpro2.jsp</h1>
	
	<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	int age = Integer.parseInt(request.getParameter("age"));
	//Integer.parseInt 문자열을 int로 바꿔준다.
	
	%>
	
	<h2>아이디 : <%=id %></h2>
	<h2>비밀번호 : <%=pw %></h2>
	<h2>나이 : <%=age %></h2>
	
	<hr>
	<h2>자바빈 객체만 사용해서 정보 저장후 출력</h2>
	<%
	//자바빈 객체 생성
	Javabean2 jb2 = new Javabean2();
	//객체안에 전달된 정보 저장
	jb2.setId(id);
	jb2.setPw(pw);
	jb2.setAge(age);
	//객체안에 정보 출력
	%>
	<%=jb2.getId() %> <br>
	<%=jb2.getPw() %> <br>
	<%=jb2.getAge() %> <br>
	
	<hr>
	
	<jsp:useBean id="usejb" class="com.itwillbs.beantest.Javabean2"></jsp:useBean>
	
	<%-- <jsp:setProperty property="id" name="usejb"/>
	<jsp:setProperty property="pw" name="usejb"/>
	<jsp:setProperty property="age" name="usejb"/> 
	전달되는 모든 파라미터를 프로퍼티에 넣겠다.
	--%>
	
	<!-- 전달된 파라미터의 모든 값을 자바빈 객체에 모두 저장 -->
	<jsp:setProperty property="*" name="usejb"/>
	
	
	<jsp:getProperty property="id" name="usejb"/>
	<jsp:getProperty property="pw" name="usejb"/>
	<jsp:getProperty property="age" name="usejb"/>
	
	
	
	
	
	<h2> 액션태그 + 자바빈 객체 사용</h2>
	
</body>

</html>