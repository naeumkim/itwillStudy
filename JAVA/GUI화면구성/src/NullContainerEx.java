import javax.swing.JFrame;
import javax.swing.JLabel;

/*
	배치관리자를 지정하지 않고 내가 원하는 대로 컨테이너에 배치할 수 있다.

*/
public class NullContainerEx extends JFrame{
	//기본 생성자
	
	public NullContainerEx() {
		//프레임창의 제목 설정
		this.setTitle("NullContainer Sample");
		//프레임창 내부에 부착된 ContentPane 도화지에 배치관리자를 지정하지 않으면, 기본적으로 특정배치관리자로 설정되어 있다.
		//그러므로 우리는 특정배치관리자를 ContentPane도화지에서 제거해야한다.
		this.setLayout(null);
		
		//JLabel컴포넌트를 생성하고 직접 위치와 크기를 지정한다.
		JLabel la = new JLabel("Hello, press Button!");
	
		//위 생성한 JLabel객체의 텍스트 내용을 ContentPane도화지의 130,50위치로 지정해서 배치하기 위해 설정
		la.setLocation(130, 50);
		//위 생성한 JLabel객체영역의 크기를 200너비 x 20높이로 설정
		la.setSize(200,20);
		
		//ContentPane도화지에 JLabel컴포넌트 부착
		this.add(la);
		
		//9개의 버튼 컴포넌트들을 생성하고 모두 동일한 크기로 설정한다.
		//위치는 서로 다르게 설정해서 ContentPane도화지에 부착
		for(int i=0;i<=9;i++) {
			//버튼 컴포넌트 생성
			
		}
		
		
		
		
		//프레임창의 사이즈 설정 후 보이게 하기
		this.setSize(300,200);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {

		new NullContainerEx();
		
	}

}
