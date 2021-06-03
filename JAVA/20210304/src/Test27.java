


//switch 조건문 연습문제2
public class Test27 {

	public static void main(String[] args) {
		
		
		// Math 클래스 내부에 있는 random 함수를 호출하여
		//1~10 사이의 랜덤한 값 하나를 정수로 얻어 int score 변수에 저장
		int score = (int)(Math.random()*10)+1;
		
		//문자열 저장할 String 타입의 msg변수 선언 하고 "" 저장
		String msg = "";
		
		
		//score = score * 100; < 다른 표기법으로 작성
		score *= 100;
		
		msg = "당신의 점수는 " + score + "이고, 상품은 ";
		
		switch (score) {
			case 1000 : msg += "자전거, ";
			case 900 :msg += "TV, ";
			case 800 :msg += "노트북 컴퓨터, ";
			case 700 :msg += "자전거, ";
			default :msg += "볼펜";
			
		
		
		}
		
		
		
		/*
		  switch문을 이용하여 
		  1000점일 경우 msg변수에 "자전거, " 누적
		  900점일 경우  msg변수에 "TV, " 누적
		  800점일 경우 msg변수에 "노트북 컴퓨터, " 누적
		  700점일 경우 msg변수에 "자전거, " 누적
		  위의 모든 점수에 만족하지 않을때.. msg변수에 "볼펜" 누적
 		  
		 
		 */
		
		
		System.out.println(msg + "입니다.");
		
		
		 
		
		
	}

}
