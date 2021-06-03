
//주제 : 같은 패키지 내부에서 접근하는 접근제어자 연습

class Super{
	//접근제어자 public, 4바이트 크기의 정수를 저장할  num1변수 선언 후 10초기화
	public int num1 = 10;
	//접근제어자 protected, 4바이트 크기의 정수를 저장할 num2변수 선언 후 20초기화
	protected int num2 = 20;
	//접근제어자 default, 4바이트 크기의 정수를 저장할 num3변수 선언 후 30초기화
	int num3 = 30;
	//접근제어자 private, 4바이트 크기의 정수를 저장할 num4변수 선언 후 40 초기화
	private int num4 = 40;
	//private로 선언된 num4변수의 값을 반환하는 getNum4메소드 선언( 접근 제어자 public)
	public int getNum4() {
		
		return num4;
	}
	
	
}




//super클래스를 상속받아 새롭게 정의하는 sub클래스 만들기

	//접근제어자 private, 4바이트 크기의 정수를 저장할 num5변수 선언

	//접근제어자 public, 리턴하지 않음, print메소드 선언
	/*
		출력할 내용
		num1 변수에 저장된 값 출력
		num2 변수에 저장된 값 출력
		num3 변수에 저장된 값 출력
		num4 변수에 저장된 값 출력
		num5 변수에 저장된 값 출력

	*/

class Sub extends Super{
	private int num5;
	
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		//num4는 컴파일 에러 발생함
		System.out.println(getNum4());
		System.out.println(num5);
		
	}
	
}

public class Test83 {

	public static void main(String[] args) {
		//sub 객체 생성후 print메소드 호출
		Sub sb = new Sub();
		
		sb.print();
		
		
		/*
		출력결과 
		10
		20
		30
		40
		0
		 */
	}

}
