//Swing을 위한 import
//JoptionPane : 자바스크립트에서 입력받을 수 있는 메세지 박스와 비슷한 역할을 하는 클래스

import javax.swing.JOptionPane;


public class singleThreadEx2 {

	//메인스레드(주스레드,싱글스레드,단일스레드)에게 작업1,작업2를 시키자.
	public static void main(String[] args) {
		//작업1 : 다이얼로그창에 입력받은 내용을 화면에 출력하는 작업
		
		
		String input = JOptionPane.showInputDialog("입력하세요.");
		//입력받은 데이터를 input에 저장
		//showInputDialog메소드의 반환객체는 다이얼로그창
		//다이얼로그창에서 입력받은 값은 String 문자열로 리턴받는다.
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		
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
				
	}//main

	
	
}

//결론 : 순차적으로 작업이 실행된다.  싱글(main)스레드에서 2개의 작업을 하는데...
//첫번째 작업1(다이얼로그 작업)이 끝난 후에 작업2(카운트다운작업)을 하는 것을 알 수 있다.