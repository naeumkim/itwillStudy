<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WEB-INF/views/productDetail.jsp</h1>
	
	
	<hr>
	<h2>상품객체</h2>
	컨트롤러에서 전달된 객체 정보<br>
	<h2>${vo}</h2>
	<!--to String이 있어야 위처럼 뜸  -->
	
	
	<h4> 상품명 : ${vo.name }</h4>
	<h4> 가격 : ${vo.price }</h4>
	<!-- vo get메서드 호출한것  -->
	
	<hr>
	
	<h1>전달되는 속성의 key값이 없을경우 클래스명의 첫글자만 소문자로 변경</h1>
	
	<h2>${productVO }</h2>
	<h4> 상품명 : ${productVO.name }</h4>
	<h4> 가격 : ${productVO.price }</h4>

</body>
</html>