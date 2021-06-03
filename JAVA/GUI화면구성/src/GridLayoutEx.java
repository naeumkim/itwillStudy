import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
	배치관리자 종류 >  GridLayout클래스
	-컨테이너 공간을 동일한 사각형 객자(그리드)로 분할하고 각 셀에 하나의 컴포넌트 배치
	-객자 구성은 생성자에 행수와 열수 지정
	-셀의 왼쪽에서 오른쪽으로, 다시 위쪽에서 아래로 순서대로 배치
	
	
	GridLayout배치관리자 클래스로 입력 폼 만들기 : 4 x 2 그리드로 분할
	JLabel클래스 <  텍스트를 표시하기위한 컴포넌트
	JTextField클래스 < 텍스트를 입력하기 위한 컴포넌트
*/

public class GridLayoutEx extends JFrame{//프레임창 역할을 하는 사용자정의 클래스

	public GridLayoutEx() {
		//프레임창 제목 설정
		this.setTitle("GridLayout Sample");
	
		//4 x 2그리드의 GridLayout배치관리자 객체 생성
		GridLayout grid = new GridLayout(4, 2);
		
		//그리드 사이의 수직간격을 5픽셀로 설정
		grid.setVgap(5);
		
		//GridLayout배치관리자 객체를 프레임창 내부에 부착된 ContentPant도화지에 설정
		
		this.setLayout(grid);
		
		//라벨(JLabel) 및 텍스트필드 컴포넌트들을 생성해서 ContentPane도화지에 추가
		this.add(new JLabel(" 이름")); //이름 텍스트 표시
		this.add(new JTextField("")); //입력할 수 있는 곳
		
		this.add(new JLabel(" 학번"));	//학번 텍스트 표시 
		this.add(new JTextField("")); //입력할 수 있는 곳
		
		this.add(new JLabel(" 학과"));
		this.add(new JTextField(""));
		
		this.add(new JLabel(" 과목"));
		this.add(new JTextField(""));
		
		
		//프레임창 사이즈 설정 및 보이게 설정
		setSize(300, 200);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		//프레임창 객체 생성
		new GridLayoutEx();
	}

}
