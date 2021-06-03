
//사용자 정의 메소드 만들기 연습
public class Test48 {

	// 메소드를 만들어 보자.

	// 메소드 이름: javaspeak
	// 기능 : "쉬운 자바!"출력 하는 기능
	public static void javaspeak() {
		System.out.println("쉬운 자바!");
	}

	// 메소드 이름: absTest
	// 기능 : "절대값을 구하는 메소드" 출력하는 기능
	public static void absTest() {
		System.out.println("절대값을 구하는 메소드");
	}

	// 메소드 이름: move
	// 기능 : "이동하라!" 출력하는 기능
	public static void move() {
		System.out.println("이동하라!");
	}

	public static void main(String[] args) {

		// 위에 만들어 놓은 javaspeak메소드 호출하여 그 기능이 실행 되도록하기  > 클래스명.메소드명 (static이 앞에 있을 경우, 클래스명 생략하고 메소드명으로만 호출 가능하다.)
		Test48.javaspeak();
		// absTest메소드, move메소드 각각 호출하여 그 기능이 실행 되도록 하기
		
		Test48.absTest();
		move();

	}//main

}//class
