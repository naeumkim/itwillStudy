
//ShapeClass1 추상클래스 만들기

	//draw 추상메소드 만들기, 리턴타입 void,매개변수 없음


//ShapeClass1 추상클래스를 상속받는 Circle 자식일반 클래스 만들기

	//draw 추상메소드 오버라이딩
		//오버라이딩(재구현) 내용 >  "원을 그린다" 출력


//ShapeClass1 추상클래스를 상속받는 Rect1자식 일반클래스 만들기

	//draw 추상메소드 오버라이딩
		//오버라이딩(재구현) 내용 >  "사각형을 그린다" 출력

//ShapeClass1 추상클래스를 상속받는 Trial1자식 일반클래스 만들기

	//draw 추상메소드 오버라이딩
		//오버라이딩(재구현) 내용 >  "삼각형을 그린다" 출력



abstract class ShapeClass1{
	
	abstract void draw();
}

class Circle1 extends ShapeClass1{

	@Override
	void draw() {
		System.out.println("원을 그린다.");
	}
}


class Rect1 extends ShapeClass1{

	@Override
	void draw() {
		System.out.println("사각형을 그린다.");
	}
}


class Trial1 extends ShapeClass1{

	@Override
	void draw() {
		System.out.println("삼각형을 그린다.");
	}
	
	
}

public class Test104 {

	public static void main(String[] args) {
		//추상(부모) 클래스 타입의 참조변수 ref 선언
		ShapeClass1 ref;
		//업캐스팅 > new Circle() 객체 생성 후 저장
		ref = new Circle1();
		//new Circle()객체의 draw() 메소드 호출
		ref.draw();

		//업캐스팅 > new Rect1() 객체 생성 후 저장
		ref = new Rect1();
		
		//new Rect1()객체의 draw() 메소드 호출
		ref.draw();
		
		//업캐스팅 > new Trial() 객체 생성 후 저장
		ref = new Trial1();
		//new Rect1()객체의 Trial() 메소드 호출
		ref.draw(); 
		
		
		//결론 : 추상클래스로 부터 오버라이딩된 메소드는..
		//		참조변수의 클래스타입과 무관하게 그 참조변수가 참조하고 있는 자식객체에 따라서
		//		draw()메소드의 출력결과가 달라진다. 
		
		
		System.out.println("-------------------------------------------");
	
		//추상클래스타입의 배열을 저장할 arr참조변수 선언
		ShapeClass1[] arr;
		//추상클래스 타입의 배열 3칸 생성
		arr = new ShapeClass1[3];
		
		//arr 각 인덱스 위치에 자식객체 저장
		arr[0] = new Circle1(); //업캐스팅이 일어남
		arr[1] = new Rect1(); //업캐스팅이 일어남
		arr[2] = new Trial1(); //업캐스팅이 일어남
		
		//배열의 각인덱스 위치에 저장된 자식객체들을 꺼내어서 자식객체의 draw()메소드 호출
		for(int i = 0;i<3;i++) {
			arr[i].draw();
		}
	
		
		//결론 : 배열의 각인덱스 위치에 저장된 자식객체가 다르므로..
		//		for반복문으로 일괄 처리하더라도 출력결과가 다르게 나타난다.
		
		
		System.out.println("-----------------------------------------------------------");
		
		
		//static으로 선언한 정적메소드(클래스메소드)이기 때문에 
		//메소드명 put으로 바로 호출가능
		put(new Circle1());
		put(new Rect1());
		put(new Trial1());
	}//main 메소드 끝

	//추상클래스 ShapeClass1타입의 매개변수 s를 갖는 클래스메소드 put 만들기
	//> 업캐스팅에 의해서 매개변수 s는 ShapeClass1 추상클래스로부터 확장된 자식객체를 참조할 수 있다.
	public static void put(ShapeClass1 s) {
		//s.draw(); 만 보아서는 원,삼각형,사각형 중 어느 것을 그리는 지 알 수 없다. 
		//그러나 한가지 코드로 작성된 s.draw()라는 문장으로 3가지 도형을 그리는 결과를 얻어낼 수 있다.
		//다형성
		s.draw();
	}
	
	
}//Test104
