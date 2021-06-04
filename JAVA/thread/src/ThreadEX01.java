/*
	스레드란?
	-하나의 실행프로세스 내부의 하나의 작업단위
	
	스레드를 사용하는 이유는?
	-동시에 여러가지 작업을 처리하고자 할때 사용하게 됩니다.
	
	스레드 프로그램(클래스)을 만드는 방법
	1. Thread클래스를 상속 받아 스레드 프로그램(클래스)를 만드는 방법
	2. Runnable인터페이스의 추상메소드를 오버라이딩 받아 스레드 프로그램(클래스)를 만드는 방법

	주제: Thread클래스를 상속 받아 스레드 프로그램(클래스)를 만드는 방법

*/

//Thread클래스를 상속받아 하나의 작업을 처리하는 스레드 클래스 만들기
public class ThreadEX01 extends Thread {
	
	//스레드 이름을 저장할 변수
	//String name;
	
	//스레드 이름을 매개변수로 전달받아 저장하는 생성자
	public ThreadEX01(String name) {
		//this.name = name;
		super(name); //extends 해준 Thread부모 객체의 생성자를 통해 스레드 이름 저장
	}
	
	//*콜백메소드 : JVM시스템이 어느시점에 자동으로 호출해주는 메소드, 개발자가 호출하는 메소드x  
	//작업스레드의 객체들이 해야할일을 구현해야하는 콜백메소드
	@Override
	public void run() {//run메소드는 무조건 하나만 만든다.
						//아래의 main스레드 내부의 첫번째 스레드, 두번째 스레드 객체는 똑같은 일을 하게 된다.
		int sum = 0; //누적변수
		
		for(int i=0;i<5;i++) {
			
			//작업스레드 2개중 현재 작업 중인 작업스레드에게 1초간 휴식 주기
			
			try {
				//현재 작업중인 스레드 1초 대기, 예외처리 필요
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			sum += i;
			//부모  Thread객체의 getName()메소드는 현재 작업하고 있는 스레드의 이름을 반환해준다.
			System.out.println(this.getName() + " : " + "[" + (i+1) + "번째] " + sum);
				
			
		}
	}//run

	//(주)메인스레드 > 무조건 하나만 존재해야한다.
	public static void main(String[] args) {
		//스레드 객체 2개를 생성해서 저장할 변수 선언
		ThreadEX01 t1,t2;
		
		//(자식)작업스레드1 객체 생성 (만들기)
		t1 = new ThreadEX01("첫번째 스레드"); // 작업스레드의 구별을 위해 스레드의 이름을 지어준다.
		t2 = new ThreadEX01("두번째 스레드");
		
		/*
			중요!
			스레드는 총 3개이다. 메인스레드, 작업스레드1 , 작업스레드2
		*/

		//start()메소드는 직접적으로 run()메소드를 호출하지는 않으나..
		//자바가상머신에게 자식스레드가 각각 일할 준비가 되었으니, 자바 가상머신에게 run()메소드를 호출하라고 부탁하는 메소드이다.
		t1.start();
		t2.start();
		
	
	}//main

}
