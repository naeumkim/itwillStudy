/*
	//상속연습 
	(x,y)의 한점을 표현하는 point클래스와 
	point클래스를 상속받아 컬러점을 표현하는 ColorPoint클래스를 새롭게 만들어보다.  
*/
//(x,y)의 한점을 표현하는 point클래스(부모클래스) 선언
class point{
	
	//한 점을 구성하는 x,y 인스턴스 변수 선언
	int x,y;
	//인스턴스변수 x,y에 데이터를 새롭게 초기화 시킬 set메소드 만들기

	void set(int x,int y) {
		this.x = x;
		this.y = y;
	}

	
	
	//한점의 좌표 "(x,y)" 문자열 형태로 출력하는 showpoint메소드 만들기
	void showpoint(){
		System.out.println("(" + x + "," + y + ")");
		
	}


}//point


//point 부모클래스를 상속받아 새롭게 정의하는 ColorPoint 클래스 (자식클래스) 선언

class Colorpoint extends point {
//점의 색을 문자열로 저장시킬 인스턴스 변수 color 선언
	String color;
	//점의 색을 매개변수로 전달받아 새롭게 초기화 시킬 setColor메소드 만들기
	void setColor(String color) {
		this.color = color;
	}
	
	void showColorpoint(){
	//color변수에 저장된 컬러점의 좌표를 출력하는 기능의 showColorpoint메소드 만들기
		//출력기능
		//1. color변수의 값 출력
		//2.한점의 좌표 "(x,y)" 문자열 형태로 출력
		System.out.println(color);
		showpoint(); //point클래스로부터 상속받은 메소드 사용가능
	}
}

public class Test80 {

	public static void main(String[] args) {
		//출력결과
		//red(3,4)
		
		//1.Colorpoint 객체 생성, 참조변수이름 cp
		Colorpoint cp = new Colorpoint();
		//2.부모클래스인 point클래스로부터 상속받은 set메소드 호출시 3,4 전달
		cp.set(3,4);
		
		//3.colorpoint 객체의 color변수에 "red" 문자열을 저장하기 위해 메소드 호출
		cp.setColor("red");
		//4.컬러점의 좌표를 출력하는 showColorpoint메소드 호출
		cp.showColorpoint();
	}

}
