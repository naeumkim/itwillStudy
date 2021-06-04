import javax.swing.JOptionPane;

/*
	전 MultiThreadEx3.java파일의 예제 업그레이드 시키기
	업그레이드 내용 :  10초간 다이얼로그창에 아무것도 입력하지 않으면 강제로 다이얼로그창 종료되게 하기


*/
public class multiThreadEx3 { //메인스레드가 존재하는 클래스
	
	//사용자가 10초안에 데이터를 다이얼로그창에 입력했는지 판단(검사)하는 플래그 변수 선언
	//플래그 변수의 값이 true로 저장되면 입력 했음
	//false로 저장되면 입력 안 했음
	
	 static boolean inputCheck = false;
	 
	 
	 

	//메인스레드 역할 : 두개의 작업스레드 객체를 생성하고 실행시키는 역할만 함
	public static void main(String[] args) {

		//작업1을 하는 inputThreadDemo클래스로 부터 스레드 객체 생성후 작업 시작 시키기
		new InputThreademo().start();
		
		
		//작업2를 하는 MultiThreadDemo3클래스로 부터 스레드 객체 생성후 작업 시작 시키기
		new MultiThreadDemo3().start();
		
		
		
	}

}

//작업 1스레드 객체를 생성하기 위한 클래스 설계도
class InputThreademo extends Thread{

	@Override
	public void run() { //스레드가 해야할일 작성하는 곳 작업1. 다이얼로그창에 입력받은 내용 출력
		 System.out.println("10초 안에 값을 입력해야합니다.");
		 String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
		 System.out.println("입력 한 값 : " + input);
		 //다이얼로그창에 데이터를 입력했으면, 체크변수의 값을 true로 바꿔서 저장
		 multiThreadEx3.inputCheck = true;
		 
		 
	}
	
}


//작업 2스레드 객체를 생성하기 위한 클래스 설계도
class MultiThreadDemo3 extends Thread{
	
	@Override
	public void run() { //스레드가 해야할 일 작성하는 곳 작업2. 카운트다운 작업
		for(int i=10;i>0;i--) {
			
			//사용자가 10초 안에 다이얼로그창에 데이터를 입력하면? (inputCheck변수에 저장된 값이 true이면?)
			if(multiThreadEx3.inputCheck) {
				return; //카운트다운 작업을 끝내기 위해 for반복문을 빠져나가자
				
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//for
		
		System.out.println("10초 동안 값이 입력되지 않아 프로그램을 강제로 종료합니다.");
		//프로그램 강제종료
		System.exit(0);
	}//run
	
}
