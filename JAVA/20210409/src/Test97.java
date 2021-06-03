
/*

	메소드 오버라이딩이란?
	- 상속관계의 부모클래스의 메소드의 선언부 (메소드이름,매개변수 이름,반환타입)을 모두 동일하게 
	자식클래스의 내부에 정의하되, 메소드의 {} 사이의 구현내용만 재정의하는 것.
	
*/

class P{//부모 클래스
	public void p() {//메소드의 선언부
		System.out.println("부모 P클래스 내부의 메소드"); //메소드의 구현부
	}	
}


class C extends P{//p클래스의 모든 멤버를 물려받는 C자식 클래스
	//C클래스의 멤버 
		
	
		//부모 p클래스에 존재하는 p()메소드를 자식C클래스 내부에 메소드 오버라이딩
		//단축키 > alt + shift + s  >  v
	
	@Override  // < 현재 아래에 있는 p()메소드는 부모클래스로 부터 재정의된 메소드이다라고 표현
	public void p() {//메소드의 선언부는 부모클래스에 있는 부분 그대로 작성
		//메소드의 구현부를 재정의 시키자.
		System.out.println("자식C클래스에서 재정의 된 p메소드");
	}
	
	
	//C클래스의 멤버(메소드)
	public void c() {
		System.out.println("자식C클래스 내부의 메소드");
	}
	
}

public class Test97 {

	public static void main(String[] args) { //메소드의 선언부
		//메소드의 구현부 
		
		//C클래스로 부터 객체 생성
		C c = new C();
		
		//부모클래스로부터 오버라이딩 된 메소드 호출 가능
		c.p();
		c.c();
		
		
	}

}
