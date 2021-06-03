/*
 제네릭메소드
 > 한번에 서로 다른 데이터 형식을 출력해주는 기능의 메소드





*/
public class Test139 {

	/*
	
	//사용자 정의 PrintArray메소드 만들기
	
	public static void printArray(Object[] objArray) {
								//integer[] 에서 Object[]로 변경
								//위와 같이 1. Object타입의 매개변수로 모든 자식배열을 받아야한다.
								//2. 아래의 향상된 for문에서도 마찬가지로 Object타입으로 바꿔줘야 한다. 
		
		
		//매개변수로 intArray로 전달받은 integer배열에 저장된 integer객체의 갯수만큼 반복해서 꺼내와 출력
		//향상된 for문 사용
		
		//for(배열의 각 인덱스 위치에서 꺼내온 객체를 저장할 참조변수 선언 : 배열) {
		
		
		 Object최고 부모클래스타입의 문제점
		 - Object타입의 메모리 공간은 모든 클래스 타입의 최고 부모 클래스 이므로
		 Object공간이 더 크므로 메모리 낭비가 된다. 
		 > 그래서 제네릭 메소드를 만들어서 사용한다.
		
		
		for(Object element : objArray) {	
			System.out.printf("%s ", element);
			
			//%s 문자열 기호
		}
		
		*/
	
	
	//제네릭 메소드란
	//- 매개변수로 전달받은 데이터가 Integer배열이든 Character배열이든 상관없이
	//매개변수로 전달받은 데이터를 그대로 받아 동적으로 실행하는 메소드 
	
	//<> 의 뜻 > 객체를 생성할때 전달받을 타입을 지정하는 오브 기호
	//
	
	
	//사용자 정의 제네릭 printArray메소드 만들기
	//> 제네릭 E타입으로 printArray메소드를 만들겠다.
	//매개변수로 전달 받은 데이터가 뭐가 되든지 간에 매개변수로 전달받은 데이터의 타입에 맞게 자동으로 
	//E가 변환되어 모든 배열을 매개변수로 받을 수 있게 제네릭메소드 만들기
	public static <E> void printArray(E[] allArray){
		
		
		//매개변수로 전달받은 배열의 타입에 맞게 for조건식의 변수 또한 자동으로 바뀌어서 , 
		//자동으로 바뀐 클래스타입의 참조변수 allArray매개변수에 저장된 전체배열의 객체들을 꺼내어 저장할 수 있다.
		
		//제네릭 타입으로 지정해 놓으면 다운캐스팅을 할 필요가없다.
		for(E element: allArray) {
			System.out.printf("%s  ", element);
		}
		
		
	}



	public static void main(String[] args) {
		//integer객체들을 저장시킬 배열선언과 생성
		Integer[] intArray = {new Integer(1), 2, 3, 4, 5};
	
		//for문을 이용해서 위 integer배열에 저장된 integer객체들을 반복해서 꺼내와 출력해도 되지만
		//사용자 정의  printArray메소드를 하나 만들어서 main 메소드 내부에서 printArray메소드를 호출
		
		printArray(intArray); //위 메소드 호출시.. integer배열 전달 
		
		//Character객체들을 저장시킬 배열선언과 생성
		Character[] charArray = {'A',new Character('B'),'C'};
		
		printArray(charArray);
		
		
		
		
		
	}

}
