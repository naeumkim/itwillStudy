class Parent2 {
	
	public void ParentPrn() {
		System.out.println("부모클래스 : ParentPrn 메소드");
	}
	
	
}


class Child2 extends Parent2{
	
	public void ChildPrn() {
		System.out.println("자식클래스 : ChildPrn 메소드");
		
	}
	
	
}



public class Test96 {

	public static void main(String[] args) {
		/*업캐스팅 및 다운캐스팅의 예
			
			업캐스팅 요약
			1.자식클래스를 이용해 자식객체 생성 후, 부모클래스타입의 참조변수에 대입(업캐스팅함)
			2.부모클래스의 참조변수에 저장된 자식객체의 주소로 자식객체 메모리를 참조할 수 있다라는 뜻(업캐스팅)
		*/
		
		//업캐스팅
		//부모클래스타입   참조변수   = 자식객체;    
		Parent2          p2      = new Child2();
		
		//단점 : 업캐스팅을 함으로써 부모클래스타입의 참조변수로 사용할 수 있는 자식객체(new Child2())의 멤버는 
		//부모클래스 내부에 있는 멤버만 사용할 수 있다는 단점이있다.
		p2.ParentPrn(); //부모클래스의 있는 멤버만 호출가능
		// p2.ChildPrn(); 부모클래스에 없기 때문에 호출 불가능
		
		
		//업캐스팅의 단점을 해결 (ChildPrn()메소드까지 호출 가능하게 하자) 하기 위해, 다운캐스팅을 한다. 
		//다운 캐스팅의 순서
		//순서1. 자식클래스 타입의 참조변수를 선언한다.
		Child2 c2;
		//순서2. 자식클래스 타입으로 선언한 참조변수에 (부모클래스 타입의 참조변수에 저장된
		//자식객체의 주소값을 대입함)(강제로 다운캐스팅 시켜야함.)
		c2 = (Child2)p2;
		
		// Child2 c2 = (Parent2  p2 = new Child2();)
		
		//다운캐스팅으로 인해 Child2클래스타입의 참조변수 c2로
		//ChildPrn() 메소드와 ParentPrn() 메소드 호출 가능
		
		c2.ParentPrn();
		c2.ChildPrn();
		
		/*다운 캐스팅의 잘못된 예*/
		/*생성한 부모객체를 자식클래스 타입의 참조변수에 저장하여 접근하려고 시도한 잘못된 예*/
		
		//부모클래스 타입의 참조변수에 부모객체 생성하여 저장
		Parent2 p3 = new Parent2();
		
		//다운캐스팅 시도!
		//순서1. 자식클래스 타입의 참조변수 선언
		Child2 c3;
		//순서2. 순서1에 부모클래스 타입의 참조변수에 저장된 자식객체의 주소값을 대입함
		c3 = (Child2)p3;
		
		//잘못된 다운캐스팅 이후 Child2클래스 타입의 c3참조변수로 각각의 메소드들을 호출 해보자.
		c3.ChildPrn();
		c3.ParentPrn();
		
		//Test96.class 파일을 JVM이 실행시 예외(에러)가 발생한다.
		//Exception in thread "main" java.lang.ClassCastException: class Parent2 cannot be cast to class Child2 (Parent2 and Child2 are in unnamed module of loader 'app')
		//at Test96.main(Test96.java:69)
		
		/*
		 기본데이터(int,double...)들과는 달리 클래스 데이터 간의 형변환(캐스팅)은 두 단계(컴파일 단계,실행 단계)에
		 걸쳐서 JVM이 체크한다. 컴파일상의 에러를 막기 위해서는 다운캐스팅을 명시적으로 해주면 되지만,
		 Test96.class를 실행하는 단계에서 한번더 에러를 체크한다. 캐스팅 연산자에 의해 명시적인 다운캐스팅(형변환)을
		 c3 = (Child)p3; 하였지만 참조변수 c3가 객체의 클래스 타입과 일치하지 않는 경우에는 
		 실행단계에서 classCastException이라는 에러 사항이 발생하게 된다.
		 
		 결론 : 업캐스팅으로 인해 자식객체들을 참조하는 부모클래스 타입의 참조변수를 
		 다시 다운 캐스팅 해서 자식객체를 생성할때의 자식클래스 타입과 
		 참조변수의 클래스타입을 동일하게 하는 것에 한해서만 다운캐스팅을 허용한다. 
		
		정리
		다운캐스팅이랑?
		-자식클래스 타입으로 형변환하는 것.
		-멤버를 참조가능한 영역이 확대되게 하는 것을 의미.
		-컴파일러에의해 자동으로 형변환되지않는다. (프로그래머에 의한 강제로 형변환(캐스팅)이 필요)
		-객체의 클래스타입과 참조하는 참조변수의 상속관계를 생각하면서 명시적 형변환을 해야한다.
		-이전에 이미 업캐스팅이 된 참조변수값을 다운캐스팅 하는 경우에만 안전하다.
		 */
		
		//중요포인트 상속관계가 아닌 두 클래스를 이용해서 다운캐스팅을 시도한 잘못된 예
		Child2 c4;
		String str = new String();
		
		// c4 = (Child2)str; //컴파일 에러 발생 
		
		
		
	}

}
