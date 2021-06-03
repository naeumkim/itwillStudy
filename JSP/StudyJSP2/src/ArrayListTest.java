import java.util.ArrayList;
import java.util.*;
//자바유틸아래 모든 컬렉션을 import 한다.


public class ArrayListTest {

	public static void main(String[] args) {
		// 컬렉션 :  자료구조 클래스로 구현한 형태 , 제네릭
		
		//int[] arr : 고정길이 배열
		//ArrayList : 가변길이 배열 (동적 배열)
		// > 데이터의 크기 자동으로 변경 , list 계열(순서를 기억(index), 중복 허용)
		
		
		ArrayList arr = new ArrayList();
		//<E> - 제네릭
		
		
		//arr[0] = 100; 진짜 배열이 아니기 때문에 다음과 같은 접근이 불가능하다.
		//데이터 입력 
		//Integer  > int타입
		//Character >  char
		//Boolean >  boolean
		
		// * 박싱 : 기본형데이터  > 참조형 데이터 / 언박싱 : 참조형데이터 > 기본형데이터 
		//참조형 > object 상속 가능 
		// 오토 박싱 / 오토 언박싱 (1.6~ 버전부터 지원)		
		
		arr.add(100);
		arr.add(new Integer(100));
		arr.add("hello"); // String  > object 업캐스팅
		arr.add(3.1313); // 기본형 > 참조형 (오토박싱) > object업캐스팅
		arr.add(true);
		
	
		//같은 데이터 타입이 아니라도, 업캐스팅을 통해 같이 담을 수 있다. 
		// ! 기본형 데이터는 상속이 되지 않는다
		// > 위의 arr.add(100);은 기본형 타입이 아니라 참조형임 (wrapper클래스로 기본형데이터 타입을 참조형으로 변경해둠)
		// > 참조형으로 변경해서  > 업캐스팅이 가능하게 된것
		 
		
		
		
		System.out.println(arr);
		//내가 넣은 순서대로 출력된다 > 인덱스가 존재한다.
		
		System.out.println(arr.get(2));
		
		arr.add(1, 500); // 특정배열의 위치에 값을 넣을 수 있음 
		System.out.println(arr);
		
		arr.remove(0);
		System.out.println(arr);
		
		arr.remove(new Integer(100)); //arr.remove(100); > error
		System.out.println(arr); 
		
		System.out.println(arr.size());
		//arr.size() 요소의 갯수
		
		
	
	
	}

}
