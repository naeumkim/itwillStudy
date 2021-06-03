import java.util.HashMap; //Hashmap클래스에 대한 객체를 생성하기 위해 import
import java.util.Iterator;
import java.util.Map; //Map인터페이스 타입의 참조변수를 선언하기 위해 import필수
import java.util.Set;

import javax.print.attribute.standard.RequestingUserName;

/*
	 컬렉션 API에서 제공해주는 HashMap클래스
	 
	 최상위 인터페이스 Collection - 자식인터페이스 Map - 자식클래스 HashMap
	 
	 Map인터페이스를 구현한(추상메소드를 오버라이딩 해놓은) HashMap자식클래스 
	 -(키,객체) 한쌍으로 묶어서 hashMap객체메모리에 저장 
	 -HashMap 객체 메모리는 한쌍의 데이터들을 순서를 유지하지 않는 객체(데이터)들의 집합
	 -키 는 중복 허용x
	 -객체는 중복 허용 ㅇ
	 



*/
public class Test138 {

	public static void main(String[] args) {

		//부모 Map인터페이스 타입의 참조변수 map에 new HashMap()자식객체를 생성해서 저장
		Map map = new HashMap(); //업캐스팅
		
		//Map인터페이스 내부에 만들어져 있는 추상메소드 
			//Object put(Object key, Object value) 메소드
				//매개변수 value로 전달받는 객체(데이터)를 매개변수 key로 전달받는 키값에 연결하여
				//Map인터페이스를 구현한 자식객체에 저장시키는 메소드
		
		//참고 : HashMap클래스에는 Map인터페이스에 만들어져있는 put추상메소드를 오버라이딩하여 정의 해 놓았음
		
		/*HashMap객체의 put메소드를 이용하여 key와 value(객체)를 한쌍으로 묶어서 한쌍씩 저장*/
		 
		map.put(10, "one");
		map.put(20, "two");
		map.put(30, "Three");
		map.put(10, "four");
		map.put(20, "five");
		map.put(30, "six");
		map.put(60, "seven");
		map.put(70, "eight");
		
		/*HashMap객체에 저장된 모든 Key들만?
		 반환하여 Set인터페이스를 구현한 Keyset자식객체에 저장후 반환한다. 때문에 set부모 인터페이스 타입의 참조변수에
		 keyset자식객체 배열을 저장해야한다.*/
		Set keys = map.keySet(); //keyset배열 > [10,20,30,60,70]
		
		//Set keyset()메소드
				//> set : 리턴타입, keySet(): 메소드 이름
				// > 하는 역할 HashMap객체 내부에 저장된 모든 Key만 반환하는 메소드
				
				//Set인터페이스 타입으로 반환된 객체를 저장하는 이유는?
				// > HashMap객체에 저장된 key들을 중복을 허용하지 않고 저장되어 있기 때문에, Set인터페이스 타입으로 반환한여 Set인터페이스 타입의 참조변수로 받아야 한다.
				
		
		//keyset배열에 저장된 데이터들을 (hashMap배열에 저장된 key값들) 모두 꺼내어서
		//iterator인터페이스를 구현한 iter배열에 저장후 iter배열 자체를 반환
		Iterator itr = keys.iterator(); 
		
		while(itr.hasNext()) {
		
			//key얻기 (keyset배열에서 오토박싱 됐기떄문에 언박싱 해줌??)
		Integer key	= (Integer)itr.next(); //itr.next();를 오브젝트 타입으로 반환해주기 때문에 다운캐스팅
		
		//각각의 key를 이용하여 HashMap객체메모리에 저장되어있는 value(객체)얻기 > get()메소드 호출
		String value = (String)map.get(key); //object타입이기 때문에 다운캐스팅
		
			System.out.println(key + ":" + value);
		}
	
		
		//HashMap.put(key,value);
		//HashMap.get(key) > value 리턴받음
		
		//Request.setAttribute("List", new ArrayList());
		//Request.getAttribute("List"); > object타입으로 리턴
		
		
		
		}
		
	}

