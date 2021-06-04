
//작업스레드 역할을 하는 클래스
public class ThreadDemo3 extends Thread{

	//작업스레드가 할 일을 기술
	@Override
	public void run() { //하는일 : 예외를 강제로 발생시키는 메소드 호출하는 일을 한다.
		//메소드 호출
		
		throwException();
		
	}
	
	public void throwException() {//예외를 강제로 발생시키는 역할의 메소드
		
		//예외 강제로 발생시키기
		try {
			
		throw new Exception();
		}catch (Exception e) {
			//현재 스택에 있는 예외 정보를 꺼내서 출력
			e.printStackTrace();
		}
	}
	
	
	
}
