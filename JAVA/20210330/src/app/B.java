package app; //app패키지 내부에 B클래스가 만들어져 있다고 컴파일러에게 알려주는 구문이 자동으로 작성 됨.

//import문 사용하기
//-다른 패키지(lib) 내부에 작성되어 있는  A클래스를 현재 B클래스 내부에서 사용하기 위해,
//컴파일러에게 패키지명을 포한한 A클래스의 경로를 알려주어야 한다. 이런 경우 import문을 사용한다.
import lib.A;


public class B {

	public static void main(String[] args) {
			
		A a = new A();
		A a1 = new A(1,2);
		a1.prn();
		
		
	}

}
