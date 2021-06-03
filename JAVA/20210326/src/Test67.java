import java.util.Date; 
//java폴더 내부의  util폴더 내부의 Date.java파일의 Date클래스를 현재 Test67.java내부에서 사용하기 위해
// 항상 import java.util.Date구문을 작성해 놓아야한다.




/*
	메소드 오버로딩? 
	
	오버로딩? : 이미 존재하는 이름이 동일한 것을 다시 재정의 한다는 의미.
	
	메소드 오버로딩? : 동일한 이름의 메소드를 클래스 내부에 여러번 정의하는 것.
	
	동일한 이름의 메소드를 여러번 정의(메소드 오버로딩)하는 이유 
	- 동일한 이름의 메소드가 호출되더라도
		전달 인자의 자료형이나 개수로 해당 메소드를 구분해서 호출할 수 있기 때문이다.
		
	메소드 오버로딩 규칙
	> 동일한 이름의 메소드 일지라도 달라야 하는 것
	1.메소드의 전달인자의 자료형
	2.메소드의 전달인자 개수

*/

public class Test67 {

	public static void main(String[] args) {
		//오버로딩된 메소드 호출 해보기
		
		System.out.println(true); //논리값출력
		System.out.println('A'); //문자 출력
		System.out.println(128); //문자 출력
		System.out.println(3.5); //실수 출력
		System.out.println("hello"); //실수 출력

		/*
		 	결론 : 화면 출력을 위한 메소드는 println()하나인데 메소드가 여러 출력동작을 하고 있다.
		 	논리값,문자,정수,실수,문자열등 여러 출력을 한다.
		 	
		 	
		 	println() 메소드가 여러 출력할 수 있는 이유?
		 	> 메소드 호출시 전달받는 인자의 자료형을 달리하여 메소드를 여러번 정의 해 놓았기 때문이다. 
		*/
	
		//자바 API Document문서에서
		//java.io.printStream.println 메소드를 찾아 봅시다.
		//println()
		//println(boolean x)
		//println(char x)
		//...
		//println(int x)
		//등등 메소드들이 printStream클래스 내부에 메소드 오버로딩 되어있다.	
		//---------------------------------------------------------
		//쉬어가기
		//System.out.println() 해석
		//1. java.lang 패키지는 자바에서 기본으로 제공되는 패키지이기때문에, 자동으로 사용가능하게 import(추가) 된다. > 자바 컴파일러가 import문을 추가해준다.
		//2. System클래스는 java.lang 패키지에 속해있는 클래스이다. > 따라서 import문을 작성하지 않고 바로 사용할 수 있다.
		//3. java.lang.System클래스 내부에 존재하는 printStream클래스타입의 out이라는 참조변수가 static구문으로 선언되어 있다.
		// > 이 out참조변수 내부에는 PrintStream객체의 주소가 저장되어 있다.
		// 그러므로 PrintStream객체가 가지고 있는 println() 메소드를 호출하여 사용하는 것이다.
		
		
		
		
		
		
		
		
		
	}

}
