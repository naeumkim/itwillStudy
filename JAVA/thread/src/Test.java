//스레드 만들기
// 주제 : 2. Runnable인터페이스의 추상메소드를 오버라이딩 받아 스레드 프로그램(클래스)를 만드는 방법

public class Test implements Runnable{ //스레드 클래스가 아니다, (스레드가 일을 수행하는 코드가 존재하는) run메소드가 오버라이딩 되어있는 Test 클래스이다.

	//현재 작업중인 스레드 이름 저장할 변수
	String name;
	
	//스레드 이름을 전달받아 저장하는 생성자
	public Test(String name) {
		this.name =name;
		
		//super사용 x 상속 클래스가 아니므로 사용 x
	}
	
	//작업스레드들이 해야할일을 구현해야하는 콜백 run메소드 오버라이딩
	@Override
	public void run() {
		int sum = 0;
		for(int i=0;i<5;i++) {
			//현재 작업중인 스레드 1초간 휴식
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			sum += i;
			//현재 실행중인 스레드 이름 : sum 변수에 누적된 값 출력
			System.out.println(name + " : " + sum);
		}
	}//run
	
	//메인스레드
	public static void main(String[] args) { 
		//각 작업 스레드 객체들이 해야할 일이 코드로 구현되어있는 run() 메소드를 작성해 놓은 Test클래스에 대한 객체생성후 저장할 변수 선언
		Test t1,t2;
		//참고 각각의 Test객체들은 작업스레드 객체들이 아니다.
		
		t1 = new Test("첫번째 스레드"); //작업스레드 1이 일할 run()메소드가 작성되어 있는 Test객체 생성
		t2 = new Test("두번째 스레드");
		
		//실제 작업스레드1 객체를 생성시.. 작업스레드 1이 일할 run()메소드가 작성되어 있는 Test 객체를 생성자로 전달해 저장
		Thread tt1 = new Thread(t1);

		Thread tt2 = new Thread(t2);
		//위의 작업을 스레드화 작업이라고 한다.
		
		//작업스레드1 , 2 작업준비 시키기(start()메소드 호출하여 run()메소드 실행되게 하기)
		tt1.start();
		tt2.start();
		
		
		
	}

}
