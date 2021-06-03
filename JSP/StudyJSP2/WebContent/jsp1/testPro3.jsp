<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Webcontent/JSP1/testPro3.jsp</h1>
	
	<%
	//전달된 파라미터값 저장
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String classNum = request.getParameter("classNum");
	String hobby = request.getParameter("hobby");
	
	%>
	
	
	
	이름 : <%=name %>
	나이 : <%=age %>
	성별 : <%=gender %>
	강의장 : <%=classNum %>
	취미 : 
	<% 
		//취미(동일한 이름의 파라미터를 처리)
		//request.getParameterValues 배열을 담아주는 기능
		String[] hobArr = request.getParameterValues("hobby");
		
		if(hobArr != null){
			for(int i=0;i<hobArr.length;i++){
				out.print(hobArr[i]+ " ");				
				
			}
		}//if
	%>
	
	
	
</body>
</html>