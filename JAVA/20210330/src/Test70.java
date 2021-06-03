
/*
 주제 : 자바의 클래스 내부에 존재하는 변수에 대해서 알아보자.
 */

class Test{
	//멤버변수 종류 2가지
	//1.객체변수(인스턴스변수)
	// - static 단어가 붙어 있지 않은 변수
	// - 새로운 new Test();객체를 생성할때마다...
	// 	 new Test(); 객체들이 개별적으로 가지고 있는 변수
	// - 객체가 생성되어 올라가는 Heap영역의 객체 내부에 변수의 메모리를 할당 함.
	int x;
	//2. 클래스변수(정적변수)
	//	-static 단어가 붙은 변수
	//	-class Test가 올라가는 JVM의 method영역에 메모리를 할당 받는 변수
	//	-클래스 단위당 한번만 메모리를 할당함
	//	-new Test()객체를 생성하지 않고 클래스 이름으로 바로 접근 가능한 변수
	// 	-생성된 여러 new Test()객체들이 공용으로 사용되는 변수
	static int y;
	
	//생성자
	//매개변수 z의 값을 전달 받아, x변수와 y변수에 각각 누적시키는 생성자
	public Test(int z) {
		x += z;
		y += z;
		
	}
	
	
	
}

public class Test70 {

	public static void main(String[] args) {
		
		//1.클래스 변수 y에 접근하여 출력하기
		//방법 : 객체 생성 없이 클래스명, 클래스 변수명
		System.out.println("클래스명.클래스변수명 = " + Test.y);
		
		//2. 인스턴스 변수인 x를 객체 생성없이 클래스명.인스턴스 변수명으로 접근이 가능? 불가능함
		//System.out.println("클래스명.클래스변수명 = " + Test.x);
		
		//3.인스턴스변수 x에 접근하여 출력하기 위해, new Test(10); 객체 생성하자.
		Test t1 = new Test(10);
		System.out.println("Test t1객체");
		//인스턴스 변수 x에 접근하여 x변수값을 얻는 방법
		//참조변수명.인스턴스변수명
		System.out.println(t1.x);
		//클래스 변수 y에 접근하여 y변수값을 얻는 방법
		//참조변수명.클래스변수명
		System.out.println(t1.y);
		
		//결론:
		//static으로 선언된 클래스 변수에 접근하는 방법
		//1.클래스명.클래스변수명 접근가능
		//2. 객체생성후 > 참조변수명.클래스변수명 접근가능
		//------------------------------------------
		
		//Test클래스로 부터 객체 생성, 참조변수명 t2
		Test t2 = new Test(10);
		
		System.out.println("Test t2 객체");
		
		//인스턴스변수 x에 접근하는 방법 : 참조변수명.인스턴스변수명
		System.out.println(t2.x);
		
		//클래스변수 y에 접근하는 방법 :  참조변수명.클래스변수명
		System.out.println(t2.y);
		
		//결론:
		//위 출력결과를 보면 static으로 선언된 클래스변수 y는?
		//하나의 클래스 단위당 한개의 클래스변수만 JVM메모리에 올라가므로
		//위의 t1,t2참조변수에 저장된 각 객체가 
		//클래스변수 y하나를 공유받아 사용하므로
		//기존에 있던 클래스변수 y내부에 저장된 값이 계속 += 누적된다.
		
		
		//사실 확인을 위해서 한번 더 객체 생성
		Test t3 = new Test(10);
		System.out.println("Test t3객체");
		//인스턴스변수 x에 접근하여 인스턴스변수x의 값 출력
		System.out.println(t3.x);
		//클래스 변수 y에 접근하여 클래스 변수y의  값 출력
		
		//방법2 클래스명. 클래스변수명;
		System.out.println(Test.y);
		
		//방법1 System.out.println(t3.y);
		
		/*
		  중요 결론 : 
		  1. 객체 단위로 메모리할당하는 인스턴스변수(객체변수)는
		  	 인스턴스(객체) 개별적으로 따로 JVM메모리의 heap영역에 
		  	 할당하기 때문에 개별적인 인스턴스변수로 10이 각각 저장됨
		  	
		  2. 클래스변수 y는 생성된 각 객체들이 공유 받아서 사용할 목적으로
		  	 클래스를 설계할때 생각하고 만들어 주어야 한다.
		 
		 */
		
		
	}

}
