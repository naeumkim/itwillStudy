//추상클래스 연습

//문제 :  추상클래스(Animal) 내부에는 추상메소드 speak가 존재한다
//		추상클래스(Animal)를 상속하여 Dog클래스와 Cat클래스를 정의한 후 
//		각 동물의 울음소리를 출력시키시오




//추상클래스(Animal)만들기
	//동물의 소리내기 기능을 하는 추상메소드 speak선언 , 리턴타입 String

//Animal추상클래스를 상속받는 Dog자식클래스 만들기
	//speak추상메소드 강제로 오버라이딩 하기
		//오버라이딩할 내용 > "멍멍멍 멍멍" 반환 (리턴)

//Animal추상클래스를 상속받는 Cat자식클래스 만들기
	//speak추상메소드 강제로 오버라이딩 하기
		//오버라이딩할 내용 > "냐옹 냐옹" 반환 (리턴)


abstract class Animal{
	abstract String speak(); 
	
}


class Dog extends Animal{

	@Override
	String speak() {
		return "멍멍멍 멍멍";
	}
}


class Cat extends Animal{

	@Override
	String speak() {
		return "냐옹 냐옹";
	}
	
}

public class Test106 {

	public static void main(String[] args) {
		//업캐스팅을 하지 않은 출력결과
		//냐옹 냐옹
		//멍멍멍 멍멍
		Cat c = new Cat();
		System.out.println(c.speak());
		
		Dog d = new Dog();
		System.out.println(d.speak());
		
		
		//업캐스팅을 한 출력결과
		Animal a = new Dog();
		System.out.println(a.speak());
		
		
		a = new Cat();
		System.out.println(a.speak());
		//냐옹 냐옹
		//멍멍멍 멍멍
		
	}
	//클래스는 다중상속을 허용하지 않는다.
}
