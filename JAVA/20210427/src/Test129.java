
/*
	자바에서 발생하는 예외 종류 및 예외 종류의 메세지를 제공하고 예외 처리해주는 클래스들
	
	1. 정수를 0으로 나누는 경우 발생하는 예외 ArithmeticExeption 클래스
	
	2. null값이 저장된 참조변수를 이용하려고 할때 발생하는 예외
	 > NullPointExeption 클래스 
	
	3. 배열의 인덱스 범위를 벗어난 배열을 참조하려고 하는 경우에 발생하는 예외
	 > ArrayIndexOutBoundsException 클래스
	
	4.형변환을 수행할때 객체의 타입이 일치하지 않으면 발생하는 예외
	>  ClassCastException클래스
	ex)Object obj = request.getparameter("name");
	String name = obj; 에서 다운캐스팅을 해주지 않은 경우 예외 발생
		
	5. 리소스에 포함된 클래스를 사용하고자 하는데 그 클래스가 존재하지 않을때 발생하는 예외
	> ClassNotFoundException클래스
	
	
	자바에서 예외가 발생되는 코드를 예외처리 하기위한 2가지 방법
	1. try-catch 구문을 활용
	2. throw 키위드를 이용한 예외처리
	
	
	1. try-catch 구문을 활용
	문법 
		try{
			예외가 예상되는 코드 작성
		}catch(발생한 해당 예외 클래스 타입의 참조 변수 ){
			
			try{}구문 영역에서 발생한 예외를 처리하는 코드 작성
			어떤 예외가 발생했는지에 대한 정보 코드 작성 
		
		}




*/
public class Test129 {

	public static void main(String[] args) {
		
		
		System.out.println("시작");
		
		
		int su1 = 10;
		int su2 = 0;
		
	try {
		System.out.println(su1 / su2);
		
		System.out.println("예외 발생 안함");
	}catch (ArithmeticException e) { // new ArithmeticException("/by zero") 객체가 넘어온다.
		//Exception 모든 예외 클래스들의 상위클래스
	
		//예외 처리 코드 작성
		System.out.println("정수를 0으로 나눌 수 없습니다.");
		
		e.printStackTrace();
		//위 매개변수 e에 저장된 객체의 예외정보를 출력하는 메소드 2가지
		//1.e.printStackTrace()메소드
		//-예외 발생 당시의 호출 스틱에 있었던 메소드의 정보와 예외 메세지를 콘솔창에 출력해준다.
		// 예외가 발생하기 까지의 모든 과정과 예외가 발생한 소스코드의 행 번호를 출력하는 메소드 이다.
		
		//2.System.out.println(e.getMessage()메소드)
		//- 발생한 예외 객체에 저장된 메세지를 간략히 얻을 수 있게 도와주는 메소드
		//- 간략한 예외정보만 출력한다.
		System.out.println(e.getMessage());
		
	}
		
		System.out.println("끝");
	}

}
