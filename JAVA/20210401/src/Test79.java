

/*
 	주제 : 코드를 재활용하는 상속의 장점
 	- 기존의 클래스에 새로운 내용을 추가하거나 변경할때에 기존클래스에 변경된 내용만 추가하여, 
 	  새로운 클래스를 만들어 기존클래스의 변수나 메소드를 그대로 사용할 수 있다.
 */


//2차원 평면의 좌표값 한점을 나타내는 x,y를 저장하는 point2D클래스 만들기

class point2D{
	int n;
	private int x;
	private int y;
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return y;
	}

}

//3차원 공간상의 좌표값 한점을 나타내는 x,y,z를 저장하여 제공하는 point3D클래스 만들기

class point3D {
	private int x;	//point2D클래스의 x변수와 중복
	private int y;	//point2D클래스의 y변수와 중복
	private int z;	
	
	//get으로 시작하는 메소드가 하는 역할
	// > private으로 선언된 변수값을 외부클래스에 제공(반환,리턴)해 줄 목적
	
	//set으로 시작하는 메소드가 하는 역할
	// > 외부클래스에서 현재 클래스의 private으로 선언된 변수에 접근하여 새로운값을 설정할 목적
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
}	
	//변수 하나당 setter역할을 하는 메소드, getter역할을 하는 메소드 만들기 단축키 : alt + shift + s >  generate getter and setter(r)
	
	
	//-----------------------------------------------------------
	//point2D, point3D클래스의 중복된 코드간의 상속관계도입
	
	//point3D 클래스를 수정 > point3DTest 클래스로 새로 만들기
	//point2D클래스의 모든 멤버들을 상속받아 point3DTest새로운 클래스 만들기
	
class point3Dtest extends point2D {
		 
		 
		 //private int x; //point2D클래스로부터 상속받은 x변수
		 //private int y; //point2D클래스로부터 상속받은 y변수
		 private int z;

//point2D 클래스로부터 상속받아 사용하는 메소드들
//		 public int getX() {
//			return x;
//		}
//		public void setX(int x) {
//			this.x = x;
//		}
//		public int getY() {
//			return y;
//		}
//		public void setY(int y) {
//			this.y = y;
//		}
//		 
		 
		public int getZ() {
			return z;
		}

		public void setZ(int z) {
			this.z = z;
		}
		 
	 }
	





public class Test79 {

	public static void main(String[] args) {
		
	point3Dtest pt = new point3Dtest();
		
		//point2D클래스로부터 상속받아 사용하는 setX() 메소드 호출
		pt.setX(10);
		pt.setY(20);
		pt.setZ(30);
		
		System.out.println(pt.getX() + "," + pt.getY());
		System.out.println("," + pt.getZ());
	}

}
