package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//스프링 MVC형태로 테스트할 수 있도록 설정 > 왜 서버없이? > 컴파일 시간 단축

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"} //하위 모든 폴더를 가져다 쓰겠다는 뜻
		)
public class SampleControllerTest {
	//테스트 파일 > 서버없이 테스트
	
	private static final Logger logger 
	= LoggerFactory.getLogger(SampleControllerTest.class);
	
	//컨트롤러를 실행하는데 필요한 정보를 주입하는 것이다.
	
	@Inject
	private WebApplicationContext webCTX;
	//xml에서 주입받아오기 서버에서 필요한 정보들을 가져오는 과정이다.
	//root-contextxml, servlet-context.xml에서 주입받는다.
	
	//테스트용 객체, 브라우저에서 페이지 요청/응답을 처리하는 객체
	private MockMvc mockMVC;
	
	//테스트 동작전에 필요한 설정을 세팅
	//비포 어노테이션으로 테스트 실행전에 아래의 메서드를 실행하여 객체를 만들어 준다.
	@Before 
	public void setup() {
		this.mockMVC = MockMvcBuilders.webAppContextSetup(this.webCTX).build();
		logger.info("테스트 동작전 mockMVC 객체를 생성(주입)");
	}
	
	//컨트롤러 동작 테스트
	@Test
	public void testDoA() throws Exception{
		logger.info("textDoA() 메서드 호출");
		
		mockMVC.perform(MockMvcRequestBuilders.get("/doA"));
		//get방식으로 doA호출하라 
		
		
	}
	
	
	

	
	
}
