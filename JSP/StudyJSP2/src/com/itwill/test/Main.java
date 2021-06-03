package com.itwill.test;

import java.nio.channels.ShutdownChannelGroupException;

public class Main {
	//메서드 생성 showInfo() : 이름,전화번호 출력
	 
	
	public static void showInfo(String name, String tel){
		 System.out.println("이름 : " + name + " 전화번호 : " + tel);
	 }
	
	//	showScore() : 총합, 평균 출력
	void showScore(int kor, int eng, int math){
		System.out.println("총합 : " + (kor+eng+math) + " 평균 :" + ((kor+eng+math)/3.0));
	}
	
	
	public void ShowTotal(itwillBean bean){
		System.out.println("이름 : " + bean.getName()  + " 전화번호 : " + bean.getTel());
		System.out.println("총합 : " + (bean.getKor()+bean.getEng()+bean.getMath()) + 
				" 평균 :" + (bean.getKor()+bean.getEng()+bean.getMath()/3.0));
		
	}
	
	
	public static void main(String[] args) {
			itwillBean ib = new itwillBean();
			
			System.out.println(ib.toString());
			System.out.println(ib);
			//객체의 레퍼런스를 부르는 것은 레퍼런스.toString()과 같다
				
			System.out.println("--------------------------------");
			
			//객체 생성없이 학생 한명의 정보를 생성 후
			//학생 정보 출력, 점수의 총합, 평균 계산 후 출력
			
			 String name  = "홍길동";
			 String tel  = "010-1234-1234";
			 int kor = 82;
			 int eng = 77;
			 int math = 86;
			 
			 System.out.println("이름 : " + name + " 전화번호 : " + tel);
			 System.out.println("총합 : " + (kor+eng+math) + " 평균 :" + ((kor+eng+math)/3.0));
			
			//(kor+eng+math)/3) int/int기 때문에 int로 출력된다. 결과값이 다르게 나올 수 있기 때문에
			 // 3.0으로 나눠 주어야 한다.
			System.out.println("----------------------------------------------------");
			
			showInfo(name, tel);
			 Main m = new Main();
			 m.showScore(kor, eng, math);
			
			 
			 //메서드 생성 showTotal()> itwillBean 객체를 사용해서
			// 사용자 정보 + 점수 정보(총점,평균)를 출력
			System.out.println("---------------------------------------------"); 
			 
			itwillBean jung  = new itwillBean();
			jung.setName("정학생");
			jung.setTel("010-1234-1234");
			jung.setEng(80);
			jung.setKor(80);
			jung.setMath(80);

			m.ShowTotal(jung);

			System.out.println("-----------------------------------------------");
			//계산 적용 객체 Calc 생성(새로운 파일에 생성)
			//총점(SUM) - 계산 후 리턴 , 평균(AVG) - 계산 후 출력
			//해당 메서드를 오버로딩해서 점수3개를, 객체정보를 사용하는 메서드 구현	
			
			Calc c = new Calc();
			
			System.out.println(c.SUM(kor, eng, math));
			System.out.println(c.SUM(jung));
			
		
	
	}
	
	
}//main
