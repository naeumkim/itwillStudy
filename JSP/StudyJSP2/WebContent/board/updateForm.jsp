<%@page import="com.itwillbs.board.BoardBean"%>
<%@page import="com.itwillbs.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/board/updateForm.jsp</h1>
	
	<h2> 게시판 글 수정하기 </h2>
	<%
	//전달방식에 따라서 한글처리
	

	// 전달된 정보 (파라미터) 있으면 저장
		
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
	
	//DB에서 글번호에 해당하는 정보를 가져와서 출력
	
	BoardDAO bdao = new BoardDAO();
	
	
	//글번호에 해당하는 정보를 가져오는 메서드
	BoardBean bb = bdao.getBoard(num);

	//겟보드 메서드가 보드빈 bb를 리턴하므로 보드빈에 담아준 것임
	%>
	<!-- hidden태그로 Num넘겨야 DB에 처리할 수 있다.
		action="updatePro.jsp&pageNum.."으로 넘길경우 
		DB에 처리해야하는 데이터는 폼태그안에 저장(hidden)
		안하는 경우 주소줄에 저장(url)
		 -->
	
	<fieldset>
		<form action="updatePro.jsp?pageNum=<%=pageNum%>" method="post">
		<input type = "hidden" name="num" value="<%=bb.getNum()%>">
		
		글쓴이 :  <input type="text" name="name" value="<%=bb.getName()%>" readonly> <br>
		비밀번호 : <input type="text" name="pass" placeholder="비밀번호를 입력하시오."><br>
		제목 : <input type="text" name = "subject" value="<%=bb.getSubject()%>"> <br>
		내용 : <textarea rows="10" cols="30" name ="content" ><%=bb.getContent()%></textarea> <br>
		
		<hr>
		
		<input type="submit" value="글수정하기" onclick="">
		</form>
	</fieldset>
	
	
</body>
</html>