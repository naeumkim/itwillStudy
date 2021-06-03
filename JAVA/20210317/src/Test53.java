/*
6.객체 지향 프로그래밍을 하기 위한 3단계 기법을 작성 할 수 있다.

1단계 - 현실세계에 존재하는 객체를 모델링하는 단계

2단계 - 자바 프로그램에서의 클래스 설계도 만들기 단계(변수, 메소드 작성)

3단계 - 자바 프로그램 측면에서의 클래스설계도를 참조하여 객체를 생성하는 단계

 
 사과나무 객체
 
 1단계. 현실세계에 존재하는 객체를 모델링(현실세계의 객체의 데이터, 동작(기능) 추출)
 데이터 - 빨간색, 100살, 사과나무 
 동작(기능) - 흔들린다, 사과가 떨어진다.
 
 2단계. 자바 프로그램에서의 클래스class 설계도 만들기 단계 (변수 + 메소드) 
 */
class Tree { //나무설계도(나무 class)
	
	//변수만들기 : 데이터 - 빨간색, 100살, 사과나무 
	String name; 
	String color;
	int age;
	
	
	//메소드 만들기 : 동작(기능) - 흔들린다, 사과가 떨어진다 표현 용도
	void move() {
		System.out.println("흔들린다");
		
	}
	
	void down() {
		System.out.println("과일이 떨어지다");
	}
	
	
	
}//tree


public class Test53 { //자바파일 명과 똑같은 클래스는 반드시 앞에 public을 작성해줘야 한다.

	public static void main(String[] args) {
		//3단계 - 자바 프로그램 측면에서의 클래스설계도를 참조하여 객체를 생성하는 단계
		//사과나무객체 메모리 만들기 > JVM메모리의 힙영역에 사과나무 객체 메모리가 올라감
		Tree tree1 = new Tree();
	//call stack		//heap stack에 메모리를 만든다/
		
		//설계도는 method area에 올라간다.
		tree1.name = "사과나무";
		tree1.color = "빨간색사과";
		tree1.age = 100;
		
		tree1.move(); //"흔들린다" 동작을 시키기 위해..
		tree1.down(); //"사과가 떨어지다" 동작을 시키기위해..
		
		
		//배나무객체 메모리 만들기 (객체의 주소값을 저장할 참조변수 이름 tree2)
		//저장시킬 데이터 > 배나무, 파란색 배, 99살
		//"흔들린다" 동작을 시키기 위해 move 메소드 호출
		//"과일이 떨어지다" 동작을 시키기 위해 down메소드 호출	
		
		Tree tree2 = new Tree();
		tree2.name ="배나무";
		tree2.age = 99;
		tree2.color ="파란색배";
		
		tree2.down();
		tree2.move();
		
		
	}//main
	
	
	

}//test53.class
