package 이벤트처리;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
	2단계 형식의 이벤트 처리
	프레임클래스 자신이 이벤트리스너 클래스 역할을 하게 만들어 처리하는 방법
	
	주제 :  "Action"버튼을 클릭하면 "액션"으로 버튼의 문자열을 변경하고..
			다시 바뀐 "액션" 버튼을 클릭하면 "Action"으로 버튼의 문자열을 변경 시키는 토글 버튼 구현 

	이벤트 종류
	버튼에 마우스포인터를 올리는 이벤트 onmouseover
	버튿에 마우스를 클릭하는 이벤트 onclick
	

*/

//프레임 창 그리고 이벤트를 처리하는 이벤트 리스너의 역할을 하는 클래스(2단계 방법)
public class Frame3 extends JFrame implements ActionListener {

	//생성자
	public Frame3() {
		//프레임창 제목 설정
		this.setTitle("이벤트리스너작성");
		
		//프레임창 배치 관리자를 new FlowLayout()으로 설정
		this.setLayout(new FlowLayout());
		
		//프레임창의 x버튼을 클릭하면 프레임창 닫히게 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼 컴포넌트 생성하고 생성한 버튼 컴포넌트를 프레임창에 추가하여 부착
		JButton btn = new JButton("Action");
		this.add(btn);

		//버튼 컴포넌트에 이벤트 처리할 이벤트 리스너 객체(new Frame();, this) 등록
		btn.addActionListener(this);
		
		//프레임창 사이즈 설정 및 프레임을 보이게 설정
		this.setSize(300,150);
		this.setVisible(true);
			
		}
		
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//버튼을 클릭하면 호출되는 콜백 메소드
		//사용자가 클릭한 버튼 컴포넌트는?
		//ActionEvent객체의 getsource()메소드를 이용하여 반환 받을 수 있다.
		
		JButton b =(JButton)e.getSource(); //클릭당한 JButton객체 얻기
		
		//만약 JButton컴포넌트의 텍스트 문자열이 "Action"이면?
		if(b.getText().equals("Action")) {
			//JButton버튼 컴포넌트의 텍스트 문자열을 "액션" 으로 변경
			b.setText("액션");
		}else {
			//"Action"이 아니면 "Action"으로 바꾼다.
			b.setText("Action");
		}
	
	}
	
	
	public static void main(String[] args) {

		//프레임창 객체 생성
		new Frame3();
		
	}

}
//이벤트 리스너 클래스
//버튼을 클릭했을때 버튼에 관하여 Action이벤트가 발생하므로
//이벤트 종류(Action)에 대응하는  > 리스너 인터페이스 : ActionListner

//참고 ActionListner인터페이스의 추상메소드를 강제로 오버라이딩 해서 만들어야함
