<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>안녕하세요 test.jsp</h1>
	
	<% 
		//java코드 작성가능
		request.getParameter("id");
	
		//취미의 정보를 출력
		String hobby1 = request.getParameter("hobby");
		String hobby2 = request.getParameter("hobby");
		String hobby3 = request.getParameter("hobby");
		
		String[] hob = request.getParameterValues("hobby");
		
		if (hob != null){
		for(int i =0;i<hob.length;i++){
			out.print(hob[i]);
			}
		}
		
	%>
	

	<%=hobby1 %>
	<%=hobby2 %>
	<%=hobby3 %>
	
	
	<%--hob[0] --%>
	<%--hob[1] --%>
	<%--hob[2] --%>
	
	



</body>
</html>