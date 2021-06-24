package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {

	private static final Logger logger 
	= LoggerFactory.getLogger(SampleController4.class);
	
	
	//http://localhost:8088/web/doD
	//http://localhost:8088/web/doD?msg=testData //주소지이동
	@RequestMapping("/doD")
	//public String doD(@ModelAttribute("msg") String msg) { //정보 저장
	public String doD(RedirectAttributes rttr) { //정보 저장
		logger.info("doD() 호출");
		//데이터 넘기기
		//RedirectAttributes 리다이렉트일때만 사용하는 저장 컨테이너 
		rttr.addFlashAttribute("msg", "1회성 데이터 전달하기!"); //플래쉬메모리> 일회성 데이터 새로고침하면 사라짐
		
		
		//return "/doE"; doE.jsp 뷰페이지 연결 주소는 doD지만 doE페이지를 보여준다.
		//String일때만 redirect  > 특정 페이지로 이동 할 수 있다.
		return "redirect:/doE"; //특정페이지로 이동 (다른메서드 호출) //주소줄에 있는 정보 그대로 doE에 전달 
		//항상가지고 다녀야하는 정보는 주소줄에 저장해놓고 리다이렉트로..?
 		//return "forward:/doE";
	}
	
	@RequestMapping("/doE")
	public void doE(@ModelAttribute("msg") String msg) {
		logger.info("doE() 호출");
		logger.info("msg : " + msg );
	}
	
	/*RedirectAttributes 객체: 리다이렉트 페이지 이동시 사용가능한 객체
		페이지간에 데이터 전달가능(Model 기능유사)
		rttr.addAttribute(); : URI에 표시 ㅇ, f5 - 데이터 있음
		rttr.addFlashAttribute(); : URI에 표시 x, f5 - 데이터 사라짐(1회성)
		
		
		
	*/
	
	
}
