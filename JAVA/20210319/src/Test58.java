
//주제 : 기본 자료형 범위의 데이터와 참조 자료형 데이터 비교 해보기

//기본 자료형 범위의 데이터  : 10(int) , 10.0(double) , 10.0f(float).....
//참조 자료형 데이터 : string클래스타입, Test58클래스타입...
//> 생성된 객체 메모리의 주소를 저장할 변수 선언시 사용

//년도, 월, 일 정보를 제공해주는 클래스 설계도 만들기

class Mydate{
	int year;
	int month;
	int day;
	
	
}


public class Test58 {

	public static void main(String[] args) {
		//기본자료형 범위의 변수 2개 선언
		int x = 7;
		//x변수에 저장되어 있는 7을 y변수에 저장
		int y = x;
		
		System.out.println("기본자료형 변수값 출력");
		System.out.println("x= " + x + ", y= " + y);
	
		
		//참조자료형(레퍼런스형) 변수d선언
		Mydate d;
		d = new Mydate(); //d변수는 참조자료형으로 선언된 변수이기 때문에 객체의 주소값만 저장할 수 있다.
		d.year = 2016;
		d.month = 1;
		d.day = 5;
		
		
		//참조자료형 변수t t선언
		Mydate t;
		t = d; 
		
		
		System.out.println("참조자료형의 변수에 저장된 객체내부의 객체변수값들 출력 ");
		System.out.println(d.year + "/" + d.month + "/" + d.day);
		System.out.println(t.year + "/" + t.month + "/" + t.day);
		
		
		//기본자료형의 변수의 값과 참조자료형 변수값을 변경 해 봅시다.
		//--------------------기본자료형 변수값 변경-----------------
		y = 10;
		//y의 변수에 10을 넣었는데 x의 변수값은 변할까?
		//x변수의 값은 변하지 않는다.
		//기본 자료형 변수x,y는 각각 독립된 변수 메모리이기 때문이다
		System.out.println("기본자료형 변수값 출력");
		System.out.println("x = " + x+ ", y = " + y );

		
		//-------------------참조자료형 변수값 변경------------------
		//참조변수 t로 new Mydate()객체의 각 객체변수에 접근하여 값 변경
		t.year = 2007;
		t.month = 7;
		t.day = 9;
		//참조변수 d로 new Mydate()객체의 각 객체변수에 접근하여 출력하고
		//참조변수 t로 new Mydate()객체의 각 객체변수에 접근하여 변경한 값을 출력하면
		//t로 변경한 값들이 모두 출력된다.
		//이유 : 참조변수 d와 t는 하나의 new Mydate()객체를 동시에 참조하고 있기 때문이다.
		System.out.println("참조자료형의 변수에 저장된 객체내부의 객체변수값들 출력 ");
		System.out.println(d.year + "/" + d.month + "/" + d.day);
		System.out.println(t.year + "/" + t.month + "/" + t.day);
		

	}

}
