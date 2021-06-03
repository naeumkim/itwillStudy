package com.itwillbs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Myservlet1 extends HttpServlet{
	//페이지에 방문한 방문자수 카운트 서블릿 페이지
	private int cnt = 0;
	@Override
	public void init() throws ServletException {
		System.out.println("서블릿 초기화(1회 실행)");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get방식 호출 처리 메서드");
		cnt++;
		
		//웹 페이지 구성하기
    	resp.setContentType("text/html; charset=utf-8");
    	
    	PrintWriter out = resp.getWriter();
    	
    	out.print("<html>");
    	out.print("<head><title>테스트</title></head>");
    	out.print("<body>");
    	out.print("<h1>Hello 방문자수 : "+ cnt + "</h1>");
    	out.print("</body>");
    	out.print("<html>");

    	out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post방식 호출 처리 메서드");
	}

	@Override
	public void destroy() {
		System.out.println("서블릿 소멸시 실행");
	}

	
	
}
