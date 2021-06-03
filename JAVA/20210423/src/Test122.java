
/*
	자바의 wrapper클래스들에 대해서 알아보자.
	
	wrapper역할을 하는 클래스란?
	-기본 자료형의 데이터들을 객체의 변수에 저장하기 위해 사용되는 클래스 
	
	wrapper 역할을 하는 클래스들의 종류
	- int  >  Integer클래스
	- float > Float클래스
	- double >  Double클래스
	- boolean > Boolean클래스
	- byte > Byte클래스
	
	ex) int a = 1; 가능
		object obj1 = 1; 불가능 1은 int데이터타입이기 때문에 int > Integer 
		Object obj2 = 10.1 10.1은 double데이터이기 때문에  double > Double 
														float > Float

	---------------------------------------------------------------------
	
	기본자료형의 데이터를 wrapper클래스에 대한 객체에 저장하는 이유?
	: ex) showData(Object obj)메소드를 반드시 활용해야하는 상황
	
	 public static void showData(Object obj){

	 	Integer i = (Integer)obj; 로 다시 다운캐스팅
	 
	 
	 	//Object클래스의 toString()메소드를 통하여 반환되는 문자열을 출력함
	 	System.out.println(obj.toString())
	 
	 }

	이 메소드를 통해서 출력해야하는 데이터가 정수 3과 정수7이다. 
	이러한 상황에서 정수3과 정수7이 object클래스를상속하는 객체 형태가 되어야
	showData(Object obj)메소드 호출시 전달인자로 전달 될 수 잇다. 

	객체의 참조값을 전달받는 자리에는 기본자료형 데이터를 전달해야 할 경우, 
	기본자료형의 데이터를 (기본자료형의 대응되는) 각각의 wrapper클래스에 대한 객체의 변수에 저장후 
	매개변수로 전달해야한다. wrapper역할을 하는 클래스에 객체자체를 전달해서 사용해야 한다. 
	
	 

*/


// int데이터를 저장하기 위해 wrapper 역할을 하는 Integer클래스 직접 만들어 보기


class Intwrapper extends Object{
	//int 데이터를 저장할 변수
	private int num;
	
	public Intwrapper(int data) {
		num = data;
	}
	
	//Object클래스의 toString()메소드를  Intwrapper 글래스에 맞게 오버라이딩
	@Override
	public String toString() {
		
		return "" + num;
	}
	
}






public class Test122 {

	//기본 데이터 정수3과 정수 7을 wrapper클래스에 대한 객체를 생성해서
	//매개변수로 전달받아 정보를 출력할 메소드
	
	public static void showData(Object obj) {
		System.out.println(obj.toString());
	}
	
	
	public static void main(String[] args) {
		
		//Intwrapper클래스에 대한 intWrapper참조변수에는 기본자료형의 데이터 3을 저장할 수 없다.
		//직접만든 IntWrapper래퍼역할을 하는 클래스에 대한 객체를 생성한다. 
		//생성자를 호출해 3을 전달해 new IntWrapper(3)객체에 저장시킨다.
		//new IntWrapper(3);객체의 주소값을 intWrapper 참조 변소에 저장시킨다.
		Intwrapper intwrapper =  new Intwrapper(3);
		
		//new IntWrapper(3)객체에 3이 저장되어 있으므로
		//new IntWrapper(3)객체를 showData메소드 호출시 전달하여 사용할 수 있다.
		Test122.showData(intwrapper);
		
		//정수 7을 ShowData메소드 호출시 전달 하여 "7"문자열 출력하기
		showData(new Intwrapper(7));
		
		
	}

}
