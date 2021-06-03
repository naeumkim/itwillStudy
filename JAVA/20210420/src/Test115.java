/*
Object클래스의 toString()메소드
-객체메모리의 정보를 문자열로 변환해서 반환하는 메소드

Object.java 소스는 다음과 같이 toString() 메소드를 정의하고 있다.

	public String toString(){
	
		return getClass().getName() + '@' + Interger.toHexString(hashCode());
	}


*/

class PointTest extends Object {
	
	//멤버변수
	int x,y;
	//기본 생성자
	
	public PointTest() {}
	//PointTest 객체 생성시 x,y의 변수값을 초기화할 목적의 생성자
	
	public PointTest(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	//Object 부모클래스의 toString()메소드 오버라이딩
	@Override
	public String toString() {
		return "PointTest(" + x + "," + y + ")";
	}
	
	
}


public class Test115 {

	public static void main(String[] args) {
		
		PointTest pt = new PointTest(2, 3);
		
		//생성한 PointTest 객체메모리의 정보를 문자열로 출력
		
	
		System.out.println(pt.toString()); //"PointTest@76ccd017"
		//참고 : Object클래스의 toString() 메소드
		//현 객체메모리를 생성할 때 사용한 클래스이름을 얻어와서 '@'을 연결하고
		//그 객체에 대한 해시코드 값을 16진수로 변환하여 연결한 전체 문자열을 리턴
		
	}

}
