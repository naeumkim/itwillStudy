<%@page import="com.itwillbs.beantest.Javabean1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/javabean/beanPro1.jsp</h1>
	
	
	<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	//변수가 아닌 자바빈객체를 이용해 만들어 보자
	
	/////////////////////////////////////////////////////////////////////
	//com.itwillbs.beantest 패키지에 Javabean1 객체
	// id 정보를 저장
	// > 전달된 파라미터를 객체를 사용해서 저장 후 출력
	
	Javabean1 jb = new Javabean1();
	
	jb.setId(id);
	//jb.setId(request.getParameter("id")); 도 가능하다.
	
	/////////////////////////////////////////////////////////////////////////
	
	//jsp에서는[액션태그]를 사용해서 자바빈 객체를 활용한다. > html 부분에서 사용
	
	%>
	<%--
	<jsp:useBean id=""></jsp:useBean>
	<jsp:useBean id=""/>
	<jsp:useBean id="객체명(레퍼런스명)" class="클래스의 위치(패키지명)">
	--%>
	<%
		//Javabean1 jbAction = new Javabean1();
		//<jsp:useBean id="jbAction" class="com.itwillbs.beantest.Javabean1">
		//</jsp:useBean>와 같은 의미
	%>
	
	
	<jsp:useBean id="jbAction" class="com.itwillbs.beantest.Javabean1"></jsp:useBean>
	
	
	<jsp:setProperty property="id" name="jbAction" param="id"/>
	
	<%
	//객체.setID() = property="id"
	// property="id"와 param="id"값이 같을때 생략가능
	//request.parameter  + jbAction.SetID(id) 같이 사용하는 역할
	//*파라미터와 프로퍼티의 값이 동일할 경우 파라미터의 정보 생략가능
	//프로피터에 * 입력 가능하다. 
	%>
	
	아이디 : <%=id %>
	아이디(객체 사용) :  <%=jb.getId() %><br>
	<jsp:getProperty property="id" name="jbAction"/>
</body>
</html>