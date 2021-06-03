<%@page import="com.tmeal.member.MemberDAO"%>
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
<h1>loginPro</h1>

<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String pw = request.getParameter("pw");

%>
<jsp:useBean id="mb" class="com.tmeal.member.tmmemberbean"></jsp:useBean>
<jsp:setProperty property="*" name="mb"/>

<%
MemberDAO mbdo = new MemberDAO();

mbdo.login(mb);
	

%>

</body>
</html>