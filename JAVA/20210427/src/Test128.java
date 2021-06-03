/*
	예외 : 프로그램이 실행되는 도중에 발생하는 예기치 않은 에러

	예외처리 :
	프로그램 실행도중 예외가 발생하여 프로그램이 중단되는 것을 미리 예방하는 것
	예외가 발생한 부분은 어쩔 수 없어도 이외의 영역은 끝까지 수행될 수 있도록 하기 위함.
	
	자바에서 처리가능한 예외의 종류
	- 정수를 0으로 나눌경우 
	- 배열의 범위를 벗어나서 배열에 접근한 잘못된 경우
	- 파일 입출력 예외
	
	
주제 : 어떤 데이터를 0으로 나누어 고의적으로 예외를 발생시킨 프로그램 >
예외가 발생될것이 예상되는 부분을 if문을 사용해 예외처리하기


*/
public class Test128 {

	public static void main(String[] args) {
		
		int a = 10;
		int b01 = 0;
		int b02 = 2;
		int c = 10;
		
		
		//a변수에 저장된 값을 b02변수에 저장된 값으로 나누기 위하여, 예외가 발생 예상되는 부분을 조건 검사 
		if(b02 == 0) {
			System.out.println("예외 상황이 발생됩니다.");
			
		}else {
			
			c = a / b02; //b02변수에 저장된 값이 0이 아닐때만 나눈다.
			
			System.out.println("c :" + c);
			
		}
		
		if(b01 == 0) {
			
			System.out.println("예외 상황이 발생됩니다.");
		}else {
			c = a / b01; // 10/0 예외가 발생하는 코드
			//b01변수에 저장된 값이 0이 아닐때만 나눈다. 
			System.out.println("c :" + c);
		}
		
		
		
		System.out.println("프로그램 코드가 모두 실행되어 종료됩니다.");
		
		
		/*
			결론 :  조건문 if문으로 예외처리를 할 수도 있지만, 소스 길이상 번거로운 일이 될 수 있으므로
			자바에서는 예외를 검사하고 처리하는 try-catch구문을 제공한다.
		
		
		*/
	}

}
