package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {

	private static final Logger logger 
		= LoggerFactory.getLogger(SampleController2.class);
	
	
	//String 타입으로 리턴하는 동작
	@RequestMapping(value = "/doB")
	public String doB() {
		logger.info("doB() 메서드 호출");
		
		
		return "";
	}
	
	
	//http://localhost:8088/web/doB1 호출되는 doB.jsp 페이지 생성
	@RequestMapping(value = "/doB1")
	public String doB1() {
		logger.info("doB1() 메서드 호출");
		logger.info("String 타입 리턴 > 리턴결과 .jsp 호출");
		
		return "doB";
	}
	
	//String 타입으로 리턴하는 동작
	// > 리턴 문자열.jsp 페이지 호출
	////http://localhost:8088/web/doB2
	////http://localhost:8088/web/doB2?msg=test 값 전달 ㅇ
	////http://localhost:8088/web/doB2?txt=test 값 전달 x
	////http://localhost:8088/web/doB2?txt=1000&msg=1234 값 전달 x
	
	//주소 호출 > 컨트롤러 매핑 > 전달정보 저장 > 페이지 이동 > 전달정보 받아서 출력 
	@RequestMapping(value = "/doB2")
	public String doB2(@ModelAttribute("msg") String msg, @ModelAttribute("txt") int value) {
		
		//msg = "test"(x);
		logger.info("doB2() 메서드 호출");
		logger.info("result.jsp 페이지로 이동");
		logger.info("view 페이지로 전달할 정보 : " + msg);
		
		return "result";
	}
	
	
}
