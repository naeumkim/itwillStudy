

//클래스 설계도
public class point {
	
	//변수
	int x, y;
	
	//기본생성자
	point() {
		System.out.println("point기본생성자 호출됨");
		x = 2;
		y = 2;
	}
	
	//x변수의 값을 매개변수로 전달받아 초기화할 생성다.
	point(int n_x) {
		x = n_x;
	}
	
	//x,y 변수의 값을 매개변수로 전달받아 초기화할 생성자
	point(int n_x, int n_y) {
		x = n_x;
		y = n_y;
		
	}
	
	
	//x변수의 값을 매개변수로 전달받아 초기화할 메소드
	void setX(int n_x) {
			x = n_x;
	}
	
	
	//y변수의 값을 매개변수로 전달받아 초기화할 메소드
	void setY(int n_y) {
		y = n_y;
	}
	
	//x변수에 저장된 값을 제공(반환,리턴)해주는 메소드
	int getX() {
		
		return x;
	}
	
	//y변수에 저장된 값을 반환해주는 메소드
	int getY() {
		
		return y;
	}
	
	
	//x변수, y변수에 각각 저장된 값을 출력해주는 기능의 메소드
	void prn() {
		System.out.println("출력 x,y : " + x + ", " + y);
		
		
	}
	
}//point class끝
