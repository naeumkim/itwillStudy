
/*패키지와 import 연습 */


//2
//import java.util.Scanner;

//3
import java.util.*;


public class Test69 {

	public static void main(String[] args) {
		
		//1.다른 패키지에 있는 클래스 사용하기 위해
		//패키지명을 포함하는 클래스 경로명을 사용해야한다.
		
		 java.util.Scanner scanner = new java.util.Scanner(System.in);
		 
		 //System클래스의 in상수 내부에 new InputStream(); 객체가 저장되어있다.
		 //InputStream객체의 역할
		 //>채팅시 데이터를 입력하면 바이트 단위로 데이터를 읽어 들이기 위한 스트림통로 역할을 한다. 
		 
		 System.out.println(scanner.next());
		 
		 
		//import문
		//다른 패키지의 클래스를 사용할 때, 그 클래스의 경로명을 선언하여
		//자바 컴파일러에게 알려주는 구문
		//문법) import 패키지명,클래스명;
		//주의할점) 항상 클래스 밖 맨 위쪽에 import 구문을 작성해 놓아야함.
		 
		//2.
		Scanner scanner2 = new Scanner(System.in);
		System.out.println(scanner2.next());
		
		//3. java.util패키지 내부에 있는 Scanner클래스 뿐만 아니라
		//모든 클래스들을 사용가능하게 하려면...
		//문법) import패키지명.*;
		
		
		//System.in < System클래스의 in상수에 inputstream 객체 얻기
		//new Scanner(System.in) < Inputstream객체를 지니고 있는 Scanner객체 생성
		
		Scanner scanner3 = new Scanner(System.in);
		System.out.println(scanner3.next());
		
		//Scanner3.next()
		// < InputStream객체(입력한 데이터를 바이트 단위로 읽어 들일 통로)를 이용해 읽어들인 데이터들을
		// 문자열로 변환해서 얻기 위해 Scannert객체의 next()메소드를 호출하여 문자열로 변환후 반환받아 출력
		System.out.println(scanner3.next());
		
		
		
	}

}
