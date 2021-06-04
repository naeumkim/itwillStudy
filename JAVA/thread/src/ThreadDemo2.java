
//작업 스레드 클래스
public class ThreadDemo2 extends Thread{
	
	String name; //스레드이름
	int interval; //스레드 휴식 시간 지정한 값 저장
	
	//생성자 : 스레드 이름 및 휴식시간을 매개변수로 전달받아 초기화하는 생성자
	public ThreadDemo2(String name,int interval) {
		this.name = name;
		this.interval = interval;
	}

	//작업스레드가 할일을 구현 :  현재 작업을 수행중인 스레드 이름을 반복해서 출력하는일
	@Override
	public void run() {
		for(;;) {//무한반복
			//작업스레드 1초간 휴식
			try {
				Thread.sleep(interval * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("ThreadDemo(" + name + ") Printed...");
		}
	
	}//run
	
	
	//method() 메소드는 작업클래스 내부에 만들어져 있지만?  main스레드에서 동작한다.
	public void method() {
		System.out.println("called from main()");
		
	}
	
	
	
	
	
}
