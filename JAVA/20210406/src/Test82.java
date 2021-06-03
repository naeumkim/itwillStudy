
	//주제 : 상속관계에서의 접근 제어자 알아보기
//			> 부모클래스와 자식클래스가 같은 패키지에 있는 경우의 접근


class AA{
	//default 접근 제어자 이용
	//-부모클래스의 멤버가 default이면 자식클래스이든 아니든 같은 패키지에 있는 클래스이면 모두 접근 가능하다.
	int i;
	
	//protected접근제어자 이용
	//> 같은 패키지에 속한 다른 클래스에서 접근을 허용함.
	//> 같은 패키지이든 다른 패키지이든 상속받는 자식클래스는 접근 허용 
	protected int pro;
	
	//public 접근제어자 이용
	//-다른 패키지 또는 같은 패키지의 모든 클래스에서 접근이 가능함
	public static int pub;
	
	//private 접근제어자 이용
	//-같은 클래스내부에서만 이 변수에 접근을 허용함.
	//-인스턴스변수정의시 사용
	private int pri;
	
	//public 접근 제어자를 이용해 setter,getter역할을 하는 메소드 만들기
	
	public int getpri() {
		
		return pri;
	}

	public void setpri(int pri) {
		this.pri = pri;
		
	}
	
}//AA class


class BB extends AA{
	void set() {
		i =  1;
		pro = 2;
		//pri = 3; private 변수 
		setpri(3);
		pub = 4;
		
	}
	
	public String get() {
		
		return i + ", " + pro + ", " + pub + ", " + getpri();
	}
	
}




public class Test82 {

	public static void main(String[] args) {
		BB bb = new BB();
		bb.set();
	
		System.out.println(	bb.get());

	}

}
