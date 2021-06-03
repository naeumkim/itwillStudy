

//사용자 정의 메소드 만들기 연습
public class Test51 {
	//메소드 이름 : hiEveryone
	//매개변수x,리턴값x
	// 기능 : 출근 start! 출력
	
	public static void hiEveryone() {
		System.out.println("출근 start!");
		
	}
	
	
	//메소드 이름 : hiEveryoneend
	//매개변수x,리턴값x
	//기능 : "동료와 마주쳤습니다." 출력
	public static void hiEveryoneend() {
		System.out.println("동료와 마주쳤습니다.");
		
	}
	
	//메소드 이름 : hiEveryone
	//매개변수 o > 정수형(4) age
	//기능
	//"좋은 아침입니다." 출력
	//"제 나이는 13세 입니다" 출력
	//"잘 부탁드립니다" 출력
	public static void hiEveryone(int age) {
		System.out.println("좋은 아침입니다.");
		System.out.println("제 나이는 " + age + "세 입니다.");
		System.out.println("잘 부탁드립니다.");
	}
	//메소드 이름 : byEveryone
	//매개변수 x
	//기능
	//"오늘 수고 많으셨습니다" 출력
	//리턴할 값 ㅇ > 다음에 뵙겠습니다."
	public static String  byEveryone() {
		System.out.println("오늘 수고 많으셨습니다.");
		return "다음에 뵙겠습니다.";
	}
	
	//매개변수 갯수를 달리하면, 이름이 같은 메소드를 여러개 생성할 수 있다. 
	
	public static void main(String[] args) {
		/*출력결과
			출근 start!
			동료와 마주쳤습니다.
			좋은 아침입니다.
			제 나이는 13세 입니다.
			잘 부탁드립니다.
			오늘 수고 많으셨습니다.
			다음에 뵙겠습니다.
		*/
		Test51.hiEveryone();
		Test51.hiEveryoneend();
		Test51.hiEveryone(13);
		//System.out.println(Test51.byEveryone());
	
		String value = byEveryone();
		System.out.println(value);
		
	
	}

}
