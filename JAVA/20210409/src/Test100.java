
//메소드 오버라이딩시 상속되지 않고 은닉된 부모클래스의 메소드와 같이..
//부모 클래스에 정의된 변수와 같은 이름을 가진 변수를 자식클래스에서 선언 할 수 있는데..
//이러한 경우에도 부모클래스의 변수는 자식클래스에서 사용할 수 없게 된다.
//<부모클래스의 멤버변수를 상속받아 사용하는 예>


class Point2D{
	protected int x =10;
	protected int y = 20;
	
}



class Point3D extends Point2D{
	
	//부모클래스에 존재하는 멤버변수를 자식클래스에 다시 한번 정의한다면
	//Point2D에 정의된 x,y멤버변수는 사용하지 못하고 은닉화된다.
	//Point3D클래스의 x,y멤버변수의 값만 사용할 수 있다.
	
	protected int x = 40; 
	protected int y = 50;
	protected int z = 30;
	
	
	public void print() {
		System.out.println(x+ ", " + y + ", " + z);
	}
	
	
	public void print2() {
		System.out.println(super.x+ ", " + super.y + ", " + z);
	}
	
	
}


public class Test100 {

	public static void main(String[] args) {
		Point3D pt = new Point3D();
		//pt.print();// 10,20,30 < point2d로 부터 상속받은 x,y출력한것임
		pt.print(); //40,50,30 < point3d객체의 x,y,z변수 값을 출력한 것임
		pt.print2(); //10,20,30 //point2d 부모객체의 x,y 10,20을 출력
		/*
		결론 :
		
		x변수값 40, y변수값 50이 출력되는 것을 볼 수 있듯이 자식클래스에서 같은 이름의 멤버변수 x,y에 의해서 숨겨지는 부모클래스의 x,y변수를
		은닉변수 또는 쉐도우 변수라 한다.
		
		은닉된 부모클래스의 멤벼변수를 가져다가 사용해야 할 경우,
		자식클래스 메소드 내부에서 super 로 접근해서 사용하면 된다.
		super.x , super.y
		
		*/
	}

}
