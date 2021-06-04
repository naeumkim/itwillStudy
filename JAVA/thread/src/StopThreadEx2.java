
//interrupt 메소드를 이용한 스레드 강제 종료

//run메소드를 가지고 있는 일반 클래스
class StopThreadDemo2 implements Runnable{
	
	//작업스레드가 할일을 구현해 놓을 run
		@Override
		public void run() {

			try {
				//Thread.currentThread()메소드 : 현재 실행중인 스레드에 대한 정보를 반환하는 메소드
				//isInterrupted()메소드 : 현재 작업스레드를 중지해라라는 명령을 내렸는지에 대한 검사를 하는 메소드
				//						작업스레드 중지 명령을 내렸으면? true값을 반환하고, 중지명령을 내리지 않았으면 false를 반환하는 메소드
				
				//참고 : 현재 작업스레드를 중지해라라는 명령은 interrupt() 메소드를 호출한 것과 같은 뜻이다.
				/*현재 작업스레드를 중지해라라는 명령을 하지 않을 동안 반복*/
				while(!Thread.currentThread().isInterrupted()) {
					//메세지를 출력하는 일을 함
					System.out.println("Thread는 현재 동작하고 있다...");
					
					//출력  0.5초 쉬었다가 출력하게 하기
					Thread.sleep(500);
					
				}
				
			}catch (Exception e) {
				System.out.println("interrupt메소드를 이용하여 작업스레드 중지하기!");
			
			}finally {//작업스레드가 일이 끝나는 시점에 반드시 실행되어야할 문장
				//while반복문을 벗어나면 실행되는 구문
				System.out.println("Thread는 현재 dead....");
				
			}
			
		}
	
	
}








public class StopThreadEx2{

	
	
	public static void main(String[] args) {
		System.out.println("## interrupt()메소드를 이용한 스레드 강제종료 기능 시작");
		try {
			new StopThreadEx2().process();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void process() throws InterruptedException { //작업스레드 객체 생성, 작업스레드 일시키기
		StopThreadDemo2 std = new StopThreadDemo2();
		
		//실제 스레드 객체 생성
		Thread thread = new Thread(std);
		
		//작업스레드 일시키기
		thread.start();
		
		//작업스레드 일을 시킨후 메인스레드 1초 휴식
		Thread.sleep(1000);
		
		thread.interrupt();
		
		
		
	}
	
	
}
