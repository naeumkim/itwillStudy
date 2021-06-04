import javax.swing.JOptionPane;

public class multiThreadEx2 {

	
	//메인스레드 작업1. 다이얼로그창에 입력받은 내용 화면에 출력
	public static void main(String[] args) {
		
		
		//작업스레드 객체 생성후 실행
		new MultiThreadDemo2().start();
		
		
		//작업1 : 다이얼로그창에 입력받은 내용을 화면에 출력하는 작업
				String input = JOptionPane.showInputDialog("입력하세요.");
				//입력받은 데이터를 input에 저장
				//showInputDialog메소드의 반환객체는 다이얼로그창
				//다이얼로그창에서 입력받은 값은 String 문자열로 리턴받는다.
				System.out.println("입력하신 값은 " + input + "입니다.");
		
	}

}



//작업스레드 객체를 생성하기위한 스레드 역할의 클래스 
//작업2. 카운트 다운 작업
class MultiThreadDemo2 extends Thread{

	@Override
	public void run() {

		//작업2 : 카운트다운 작업
				for(int i=10;i>0;i--){
					
					System.out.println(i);
					
					//메인스레드 1초 휴식 주기
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				}//for
		
	}//run
	
	
}