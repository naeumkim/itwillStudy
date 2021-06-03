 
public class Test125 {

	public static void main(String[] args) {
		/*
			Boxing (박싱)
			
			-JVM가상머신의 호출스텍상 메모리 공간에 있던 기본데이터타입의 데이터를
			JVM가상머신의 heap상 메모리 공간에 객체를 생성해서 기본데이터값을 객체메모리에 복사해 놓는것.
			-기본데이터타입의 데이터를 객체의 인스턴스 변수에 저장하는 작업
			
			Boxing (박싱)하는 방법
			int데이터를 Integer클래스의 객체의 변수에 저장하는 방법
			> Integer클래스의 valueOf()메소드를 사용함
			
			*/

		

		//기본데이터타입의 값을 변수에 저장
			int n = 10;
		//참조데이터 타입의 변수 num선언
		Integer num;
		// Integer 클래스의 valueOf메소드 호출시 기본데이터 10을 전달하면
		// new Integer(10); 객체에 10을 저장(박싱) 후
		// new Integer(10); 객체를 리턴해준다.
		
		num = Integer.valueOf(n); // new Integer(10);
		
		
		
		/*UnboXing(언박싱)
		객체의 인스턴스변수에 저장되어 있는 기본데이터값을 꺼내는 작업
		
		
		UnboXing(언박싱) 하는 방법
		>Integer클래스의 intValue()메소드를 사용함
		
		
		*/
		
		//박싱 : 기본데이터값을 객체의 인스턴스 변수에 저장하는 작업
		Integer it = new Integer(10);
		//언박싱 : 객체의 인스턴스 변수에 저장되어 있는 기본데이터값을 꺼내는 작업
		int in = it.intValue();
		//언박싱 
		int in2 = num.intValue();
		
		System.out.println(in);
		System.out.println(in2);
		
		
	}

}
