
public class Test2 {
	
		//자바 프로그램이 시작되는 공간
		//main메소드(main)스레드

	public static void main(String[] args) {
		
//변수 생성 및 변수에 값 저장(변수 선언 및 초기화) 연습하기
		
		//4바이트 크기의 정수 데이터를 저장할 n이라는 이름의 변수 메모리 만들기
		int n;
		//n변수에 123저장
		n = 123;
		//4바이트 크기의 실수 데이터를 저장할 f라는 이름의 변수 메모리 만들기
		float f;
		//f변수에 3.14저장
		f = 3.14F;
		//2바이트 크기의 문자를 저장할 c라는 이름의 변수 선언 및 A문자 초기화
		char c = 'A';
		//2바이트 크기의 문자를 저장할 c2라는 이름의 변수 선언 및 홍 문자 초기화
		char c2 = '홍';
		//1바이트 크기의 논리값을 저장할 b라는 이름의 변수 선언 및 true 초기화 
		boolean b = true;
		//4바이트 크기의 실수값을 저장할 b2라는 이름의 변수 메모리 만들기
		float b2;
		//b2변수에 150.3저장
		b2 = 150.3f;
		
		//각 변수에 저장되어 있는 값들을 출력
		System.out.println(n);
		System.out.println(f);
		System.out.println(c);
		System.out.println(c2);
		System.out.println(b);
		System.out.println(b2);
		
		//문자열을 저장할 변수 타입 -> String 클래스 타입
		//예)홍길동이라는 문자열을 저장할 name이라는 이름의 변수 선언
		String name;
		name = "홍길동";
		//참고 : 자바에서 문자열을 나타낼때 "큰따옴표로 나타낼 문자열을 감싼다.
		System.out.println(name);
		
		
		
	}

}
