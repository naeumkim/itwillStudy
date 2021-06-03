<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WebContent/fileupload/file_down.jsp</h1>
	
	<%
	//파라미터값 저장(filename)
	String fileName = request.getParameter("filename");
	//get방식으로 받아왔으니 한글처리 필요x
	
	//서버에 업로드된 파일명 생성
	
	
	//업로드한 가상 경로
	String savaPath = "upload";
	//이클립스 upload폴더
	
	//파일이 업로드된 경로
	ServletContext ctx = getServletContext();
	//서블릿 컨텍스트(내 프로젝트)의 정보를 받아오는것
	
	String sDownloadPath = ctx.getRealPath(savaPath);
	
	System.out.println("upload 폴더의 실제주소(서버안에 있는 실제주소) " + sDownloadPath);
	
	//서버에 업로드된 파일명 생성
	String sFilePath = sDownloadPath + "\\" + fileName;
	
	System.out.println("다운로드할 파일 주소 : " + sFilePath);
	
	//////////////////////////////////////////////////////////////////////////
	
	//*자바/웹 파일을 업로드, 다운로드시 파일의 확장자는 중요하지 않음.
	//> 스트림으로 데이터를 주고 받기 때문  > 해당파일 웹에서 표현하는 방식 MIME 타입 
	
	//파일업로드 
	
	// 파일을 한번에 읽고 쓰기하는 배열(버퍼)
	byte[] b = new byte[4096];
	
	
	//파일 입력스트림 객체 (서버에 저장된 파일을 불러오기)
	FileInputStream fis = new FileInputStream(sFilePath);
	//파일객체를 전달 or 파일 주소를 전달하는 방법의 생성자 2개가 있음
	//주소 전달 생성자를 사용
	//파일을 열어 읽어야 다운로드가 가능하므로 input 사용
	
	//다운로드할 파일의 MIME타입을 가져오기
	//*MIME타입 : 클라이언트에게 전송된 문서의 다양성을 표현하기 위한 매커니즘.
	//추가 설명 https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types
	String sMimeType = getServletContext().getMimeType(sFilePath);
	
	System.out.println("sMimeType >> " + sMimeType);
	
	//MIME타입이 없을 경우 기본 값으로 설정 
	if(sMimeType == null){
		sMimeType = "application/octet-stream";
	}
	
	//응답할 페이지에 MIME타입을 지정(jsp MIME타입 > 다운로드 파일 MIME타입으로 변경)
	//다운로드를 누르면, 다운로드 파일의 타입으로 변경한다. 
	response.setContentType(sMimeType);
	
	//* 사용자의 브라우저를 확인(IE 여부)
	//익스플로러는 다운로드시 한글파일의 이름이 깨진다, 한글이 깨지지 않더라도 공백문자가 "+"로 나오는 경우가 발생
	//이 경우를 변경 처리
	
	
	//헤더에서 사용정보를 가져오기
	String agent =request.getHeader("User-Agent");
	System.out.println("사용자 정보 : " + agent);
	
	
	//사용자 정보 안에 "MSIE" , "Trident" 둘 중에 하나라도 있을 경우 참 = ie이다(인터넷 익스플로러)
	boolean ieBrowser = (agent.indexOf("MSIE")>-1 || agent.indexOf("Trident")>-1);
	//indexOf 해당 위치 리턴  -1보다 크다  > 인덱스가 있다  > 데이터가 있다
	//msie, trident가 둘중에 하나라도 있으면  익스플로러이다.
	
	//익스플로러는 한글처리를 위해서 인코딩을 UTF-8로 변경, +기호를 공백(%20)으로 변경
	if(ieBrowser){
		fileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
		//%20 > 공백 
		//플러스 기호는 공백으로 바꿔라 
	}else{
		//모든 브라우저들 한글깨짐 방지(인코딩 방식 변경)
		fileName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
		
	}
	////////////////////////////////////////////////////////////////////////////////
	
	
	//모든 파일이 다운로드 형태로 처리 설정
	// > 브라우저에서 해석되는 파일도 다운로드처럼 처리하기 위한 설정
	// "Content-Disposition", "attachment"
	response.setHeader("Content-Disposition", "attachment; filename= "+ fileName);
	
	//다운로드
	//브라우저를 사용해서 밖으로 출력할 수 있는 통로 생성
	ServletOutputStream out2 = response.getOutputStream();
	//통로를 만드는 것
	
	int numRead;
	
	//-1 은 파일의 끝 (입력의 끝) 
	while((numRead = fis.read(b,0,b.length)) != -1 ){
		out2.write(b,0,numRead);
		
	}
	
	out2.flush(); //버퍼의 빈공백을 채워서 데이터 전달
	out2.close();
	fis.close();
	
	
	%>
	
</body>
</html>