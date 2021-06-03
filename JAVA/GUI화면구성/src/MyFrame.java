/*
	방법2. JFrame클래스를 상속받는 사용자정의 프레임 클래스를 만들어 사용자 정의 프레임 클래스에 대한 객체를 main()메소드 내부에서 생성
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class MyFrame extends JFrame {

	//생성자
	public MyFrame() {
		//프레임창 창제목 설정
		this.setTitle("방법2. 프레임창 만들기");
		
		//프레임 창에 TextField클래스와 Jbutton클래스의 객체들을 생성하여 부착
		// [                 ]  [확인] 
		JTextArea jtextarea = new JTextArea();
		//JButton jbutton = new JButton("확인");
		
		this.add(jtextarea);
		//this.add(jbutton);
		
		//프레임창 사이즈 설정
		setSize(300,300);
		//프레임창 화면에 보이게 설정
		this.setVisible(true); //false로 설정시 화면 프레임창은 존재하나, 윈도우 화면에 숨겨짐
		
		
		
		
	}
	
	
	public static void main(String[] args) {

		new MyFrame();
		
	}

}



/*
	결론 : 개발자는 MyFrame() 생성자에 필요한 코드를 마음대로 추가할 수 있다. 방법2는 방법1보다 가독성 측면에서 좋으며
		MyFrame클래스에 마음대로 메소드를 호출하여 사용할 수 있기 때문에 확장성,융통성이 뛰어나다.
		방법2를 권장함


*/