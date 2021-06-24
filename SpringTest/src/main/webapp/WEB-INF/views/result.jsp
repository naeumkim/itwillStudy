<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/result.jsp</h1>
	
	
	
	msg 전달결과 : ${msg + 1}<br>
	txt 전달결과 : ${txt + 1}
	<!--String으로 보내준 값도 int로 변환되어 +1 연산이 가능해진다.
	파라미터는 스트링 타입인데? > 스프링이 알아서 형변환을 해서 연산이 있는 경우 캐스팅해서 연산실행한다.
	  -->
</body>
</html>