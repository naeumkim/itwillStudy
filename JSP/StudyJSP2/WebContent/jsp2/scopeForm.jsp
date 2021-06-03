<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Webcontent/JSP2/scopeForm.jsp</h1>
	<% 
		//p209 영역개체(scope) / 속성(Attribute) 
		//jsp1/test3.jsp 참조
		
		//* 내장 객체중 page(pageContext),request,session,application
		//특수한 기능이 있음 > 각각의 범위를 사용하며, 그 범위 안에서 데이터를 공유할 수 있다.
		// 공유 가능한 범위  = scope , 공유되는 데이터 : Attribute
		
		
		// [영역 - scope ] - 	[영역 객체] 		- [속성의 유효 범위]
		//page				pageContext			해당페이지
		//request			request				요청이 처리되는 페이지
		//session			session				세션이 유지되는 동안 모든 페이지
		//application		application			서버 실행 후 프로그램의 모든 페이지
		
		//*pageContext : jsp페이지 정보를 저장하는 객체
		// - 다른 내장객체 호출, 페이지 흐름 제어, 에러데이터 추출...
		
		//* request : 페이지 요청시 정보를 저장하는 객체
		//	-페이지 이동시 정보 가지고 있음
		
		//* session : 하나의 웹 브라우저당 하나씩 생성, 정보를 유지하는 객체
		
		//* application : 웹 애플리케이션(프로젝트) 정보를 저장하는 객체
		// - 서버 자체의 정보, 서버 이벤트로그...
		// - 프로젝트당 1개만 생성
%>		
	<form action="scopePro.jsp" method="get">
	아이디 : <input type="text" name="id"> <br>
		<input type="submit" value="전송하기">
	
	
	
	</form>

</body>
</html>