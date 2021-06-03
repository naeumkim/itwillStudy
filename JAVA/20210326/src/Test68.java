
//자바의 특징 
//다형성(다양한 형태의 성질을 지닐 수 있다.)

//생성자 오버로딩(다형성의 특징) - 하나의 생성자 이름으로 여러개의 생성자를 만들어 놓을 수 있다.
//메소드 오버로딩(다형성의 특징) - 하나의 이름으로 다양한 형태의 메소드를 만들어 놓을 수 있다.




//System.out.println() 메소드 호출 부분 직접 만들어 보기

//System1 클래스 만들기

class System1{
	
	static PrintStream1 out = new PrintStream1();
	
	
}
//printStream1  클래스 만들기
class PrintStream1{
	//메소드들 오버로딩
	
	//한줄 띄우는 기능의 println메소드 오버로딩
	void println() {
		System.out.println(); //기능
	}
	
	//논리값을 매개변수로 전달받아 출력하는 기능의 println 메소드 오버로딩
	void println(boolean x) {
		System.out.println(x); //기능
	}
	
	//정수값을 매개변수로 전달받아 출력하는 기능의 println 메소드 오버로딩
	void println(int x) {
		System.out.println(x);
	}
	
	//실수값을 매개변수로 전달받아 출력하는 기능의 println 메소드 오버로딩
	void println(double x) {
		System.out.println(x);
	}
	
	//문자열을 매개변수로 전달받아 출력하는 기능의 println 메소드 오버로딩
	void println(String x) {
		System.out.println(x);
	}
	
	
	}//printstream클래스

public class Test68 {

	public static void main(String[] args) {
		
		System1.out.println();
		System1.out.println(2);
		System1.out.println(1.2);
		System1.out.println("만든 문자열"); //문자열을 전달하면 출력후 한줄 띄우기
		
	}

}
