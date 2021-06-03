
/*
  	생성자?
  	- 객체 생성시 딱 한번만 호출되는 메소드의 종류
  	- 생성자의 역할 : 클래스로부터 객체 생성시 객체의 변수에 저장되는 상태값을 초기화할 목적.
  	- 생성자 만들때 조건
  	   1. 클래스의 이름과 동일한 이름으로 생성자이름을 정한다.
  	   2. 리턴타입 X, 값을 리턴하지 않는다.
  	- 자바에서 객체 생성시에는 반드시 하나의 생성자는 호출되어야 합니다.
 
 */

class Number{
	//변수 
	int num;
	
	//생성자1
	//- new Number(); 객체 생성시.. Number()생성자를 호출해 num변수의 값을 저장 시킨다.
	//- 매개변수로 값을 전달 받지 않고, num변수의 값을 10으로 초기화할 생성자
	public Number() {
		num =10;
		System.out.println("기본생성자 호출");
		}
	
	//생성자2
	//-매개변수의 개수를 다르게해 여러 생성자를 생성할 수 있다.
	//-하나의 값을 매개변수로 전달 받아 num변수에 저장시키는 생성자
	public Number(int n) {
		num =n;
		System.out.println("매개변수 n이 존재하는 생성자 호출");
	}
	
	
	//메소드
	//-위 Number객체 생성시 객체변수 num에 저장된 값을 반환하는 메소드
	public int getNumber() {
		
		return num;
	}
	
	
}//class


public class Test60 {

	public static void main(String[] args) {

		//Number 클래스를 이용해서 객체 생성
		
		//해석: new Number > Number클래스의 객체 생성
		//해석: Number(); > Number() 생성자 호출
		Number num1 = new Number(); 
		 System.out.println(num1.getNumber());
		//Number클래스로 부터 객체 생성시..Number()생성자를 호출해  num변수의 값 초기화
		 //생성된 Number객체의 주소값을 num2 참조변수에 저장
		 Number num2 = new Number();
		 System.out.println(num2.getNumber());
		 
		 //Number클래스로 부터 객체생성시 Number(int n)생성자를 호출할 때 30을 전달하여
		 //num변수의 값을 초기화 시킴
		 //그리고 생성된 Number객체의 주소값을 num3참조변수에 저장
		 Number num3 = new Number(30);
		 System.out.println(num3.getNumber());
		 
		 
		 Number num4 = new Number(40);
		 System.out.println(num4.getNumber());
		 
		 
		 //결론 : 객체 생성시 생성자를 호출하면..
		 //1. 객체를 생성하는 동시에..인스턴스 변수의 값을 초기화 할 수 있다. (한줄로 코드를 작성할 수 있다.)
		 //2. 단 한번만 호출되는 생성자이므로 final로 선언된 인스턴스변수의 초기화에도 사용이 가능하다.
		 
		 
	}

}
