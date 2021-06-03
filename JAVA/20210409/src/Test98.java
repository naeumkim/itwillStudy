
//메소드 오버라이딩 연습

//도형을 나타내는 DObject 클래스 만들기
	
	//DObject클래스 타입의 참조변수 next선언

	//기본생성자
		//역할 : next변수의 값을 null이라는 값으로 초기화

	//그리는 기능을 출력하는 draw()메소드 만들기
		//출력
		//"DObject draw"
//-----------------------------------------------------------

class DObject{
	
	DObject next;
	
	public DObject() {
		next = null;
	}
	
	public void draw() {
		System.out.println("DObject draw");
	}
	
	
}


//DObject클래스를 상속받는 선을 그리기 위한 Line클래스 만들기
	//DObject클래스 내부에 만들어져 있는 draw 메소드 오버라이딩 시키기
		//재구현할 내용
		//"Line" 출력
//------------------------------------------------------------

class Line extends DObject{

	@Override
	public void draw() {
		System.out.println("Line");
	}
	//위 오버라이딩 된 draw()메소드에 대한 설명
	//> 부모클래스에 있는 draw()메소드를 오버라이딩 하면
	// line클래스를 이용해 생성된 객체는 부모클래스의 draw가 은닉되어
	//상속받지 못하게 된다.
	

}




//DObject클래스를 상속받는 선을 그리기 위한 Circle클래스 만들기
	//DObject클래스 내부에 만들어져 있는 draw 메소드 오버라이딩 시키기
		//재구현할 내용
		//"Circle" 출력

//-------------------------------------------------------------


class Circle extends DObject{

	@Override
	public void draw() {
			System.out.println("Circle");
	}
	
	
	
	
}





public class Test98 {

	public static void main(String[] args) {
		
		//주제 : 오버라이딩된 메소드를 호출해보기
		
		//Line 객체 생성 ! 참조변수 이름 a
		
		//a참조변수를 이용해 오버라이딩된 draw()메소드 호출! 
		//(참고. 곧바로 Line객체 내부에 있는 오버라이딩된 draw()메소드가 호출됨)
		
		//업캐스팅!
		//부모클래스 타입의 참조변수 p선언후  자식객체 new Line();을 생성하여 객체 주소 저장
		
		
		//업캐스팅 이후 부모클래스 타입의 참조변수 p로 draw()메소드 호출
		//(참고.p참조변수에는 실제로 저장된 객체는 자식객체인 new Line()객체가 저장되어 있으므로 
		//Line객체의 draw()메소드의 실행결과가 출력된다.)
		
		Line a = new Line();
		a.draw();
		
		
		DObject p = new Line();
		p.draw();
		//부모클래스 DObject타입의 참조변수 p로 draw() 메소드 호출시..
		//참소변수 p는 DObject클래스 타입이므로
		//1.먼저 은닉된 부모의 draw()메소드를 찾고
		//2.부모의 draw()와 같은 이름의 메소드가 자식클래스에 있는지 찾아서
		//동적으로 바인딩되어 오버라이딩된 자식객체의 draw()메소드가 호출되어 실행되게 된다.
		
		//부모객체 draw()갔다가 line의 draw()로 바인딩 돼서 line객체의 draw안 구현부가 출력되는 것이다. 
		
		
		//오버라이딩을 하면 DObject p = new Line(); 업캐스팅을 했을때  부모클래스 메소드 호출이 아닌  
		//자식클래스 호출이 가능? ㅇㅇ
		
		
		
		
		
		
	}

}
