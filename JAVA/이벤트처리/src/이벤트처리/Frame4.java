package 이벤트처리;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*

	이벤트 처리 방식 4단계 중 3단계 방법
	:프레임클래스 내부에 내부클래스 형식으로 이벤트 리스너 클래스를 만들어서 처리하는 방법
	
	주제: Frame3.java파일과 동일


*/
//프레임창 역할을 하는 클래스
public class Frame4 extends JFrame {
	
	//생성자
	Frame4(){
		//창제목 설정
		this.setTitle("3단계 이벤트 처리");
		//프레임창에 배치할 배치관리자 설정
		this.setLayout(new FlowLayout());
		//Action 텍스트 버튼 만들기
		JButton btn = new JButton("Action");
		//위 버튼에 이벤트를 처리할 이벤트 리스너 객체(내부클래스형식으로 만들어 지는 객체) 등록
		btn.addActionListener(new MyActionListener1());
		//위 버튼을 프레임창에 부착
		this.add(btn);
		//프레임창의 x버튼을 누르면 창이 닫히면서 프로그램이 완전 종료되게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//프레임창의 너비, 높이 사이즈 설정
		this.setSize(300,300);
		//프레임창 보이게 설정
		this.setVisible(true);	
	}
	
	//내부클래스
	//Frame4클래스의 내부클래스형식으로 이벤트 리스너 클래스(MyActionListner1) 만들기 (3단계 방법)
	/*
		내부클래스의 특징
		1. private으로 선언 하였기 때문에 Frame4의 외부클래스에서는 접근해서 사용할 수 없다.
		2. 내부 클래스 형식의 이벤트리스너클래스(MyActionListener1)는 Frame4클래스의 내부클래스 이므로, 자신을 둘러싼 외부클래스의 멤버에 마음대로  접근할 수 있다
		따라서 Frame4클래스의 멤버인 settitle()메소드를 호출하여 프레임창의 창제목을 다시 변경할 수 있다.
	*/
	private class MyActionListener1 implements ActionListener{

		//버튼을 클릭하면 호출되는 콜백 메소드 오버라이딩
		@Override
		public void actionPerformed(ActionEvent e) {
			//사용자가 클릭한 버튼 컴포넌트는? 이벤트 분배스레드에 의해 생성되어 매개변수로 전달 받는
			//ActionEvent객체를 통해 얻을 수 있다.  (가져오는 역할)
			JButton b = (JButton)e.getSource();
			//만약 클릭한 버튼의 텍스트 문자열이 "Action" 영문이라면? "액션"한글 문자열로 바뀌게 하고
			if(b.getText().equals("Action")) {
				//버튼의 문자열을 설정하는 setText("설정한 문자열") 메소드 호출
				b.setText("액션");
				
			}else { //만약 클릭한 버튼의 텍스트 문자열이 "액션" 한글이라면 영문으로 변경하기
				b.setText("Action");
			
			}
			
			setTitle(b.getText());
		}
		
	}//내부 클래스
	
	
	public static void main(String[] args) {
		//프레임창 역할을 하는 객체 생성
		new Frame4();
	}

}//Frame4
