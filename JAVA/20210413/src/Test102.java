/*
	추상클래스란?
	- 객체를 생성할 수 없는 미완성 설계도(클래스)
	형식
	 abstract class 추상클래스명{
	 	 멤버변수
	 	 상수
	 	 추상메소드
	 	 일반메소드
	 }
	
	추상클래스 사용목적
	- 상속받은 자식클래스는 부모추상클래스의 추상메소드를 반드시 오버라이딩 시킬 목적
	- 추상클래스로 다형성의 특징을 제공할 목적.
	
	
	추상메소드
	- 메소드의 선언부만 존재하고 메소드의 구현부분이 없는 메소드
	- 메소드 선언부 앞쪽에 abstract기술
	- 형식
	  abstract void 추상메소드명();
	  
	추상메소드사용목적
	-추상클래스를 상속받는 자식클래스에게 추상메소드의 선언부(를) 형식만 강제로 제공하여 
	 추상메소드를 재정의 시키기 위한 목적


*/


//주제 : 추상클래스를 상속받는 자식클래스 설계하기

//추상클래스(부모클래스)
abstract class Abstractclass{
	//추상메소드 : 실질적인 구현소스는 없고, 메소드 선언부만 존재하는 메소드
	abstract void Method01();
	
	//일반메소드
	void Method02() {
		System.out.println("Method02: 추상클래스내부에서 구현된 일반 메소드");
	}
	
}


// 위 추상클래스를 상속받는 자식 클래스
class Subclass extends Abstractclass{

	//반드시 오버라이딩 해줘야 에러가 나지 않는다.
	//추상클래스를 부모클래스로 해서 상속받으면, 추상클래스의 추상메소드는 반드시 (강제로) 오버라이딩 해줘야한다.
	
	@Override
	void Method01() {
		System.out.println("Method01: 자식클래스에서 재구현된 추상메소드");
		
	}
	
	
	
}

public class Test102 {

	public static void main(String[] args) {
		
		//추상클래스는 자생력이 없으므로 객체 생성을 하지 못함
		//Abstractclass abstractclass = new Abstractclass(); X
		
		//추상클래스를 상속받은 자식클래스를 이용해 객체 생성
		Subclass subclass = new Subclass();
		
		//자식클래스에 오버라이딩된 추상메소드를 호출할 수 있다.
		subclass.Method01();
		
		//자식클래스에서 상속받은 추상클래스의 일반메소드를 호출할 수 있다.
		subclass.Method02();
		
		//결론 : 추상클래스 내부의 추상메소드는 자식클래스에서 반드시 오버라이딩 해야한다. 
		
		

	}
	
}
