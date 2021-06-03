

//주제 :  기본자료형과 클래스형(참조자료형) 비교시 == 차이점
public class Test116 {

	public static void main(String[] args) {

		
		//1.기본자료형 == 연산자 사용시..
		// 서로 데이터가 같은지 물어보기 위해 사용!
		
		int a = 10, b = 10;
		if(a == b) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		
	System.out.println("------------------------------------");
	
	
		//2.클래스형(참조자료형) == 연산자 사용시...
		// > 두객체가 동일한 메모리에 할당되어 있는지 물어보기 위해 사용
		// > 두 참조변수에 저장된 객체메모리가 같은 객체 메모리인지 물어보기 위해 사용
		
		String str01 = new String("안녕");
		String str02 = new String("안녕");
		
		if(str01 == str02) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
		
		 System.out.println("---------------------------------------------------");
		 
		
		 //두 객체메모리가 같은 객체메모리를 말하는지 ==연산자를 이용해서 비교해보자
		 PointTest1 c = new PointTest1(2, 3);
		 PointTest1 d = new PointTest1(2, 3);
		 PointTest1 e;
		 e = c;
		 
		 //c참조변수에 저장된 객체메모리의 주소와 d참조변수에 저장된 객체메모리의 주소를 비교
		 if(c == d) {
			 System.out.println("c == d");
		 }
		 
		 if(c == e) {
			 System.out.println("c == e");
		 }
		 
		 /*결론 : 
		 	1. 기본자료형(기본데이터) 비교시 == 연산자 사용하면 데이터가 같은지 비교한다.
		 	2. 참조자료형(객체) 비교시 == 연산자 사용하면 두 참조변수가 동일한 객체메모리를 가리켜서 참조하고 있는지를 비교한다.
		 	 	> 두 객체메모리의 주소를 비교한다.
			*/
	}//main메소드 끝

}//Test116클래스 끝


	class PointTest1{
		int x,y;

		public PointTest1(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
