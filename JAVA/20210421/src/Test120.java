
public class Test120 {

	public static void main(String[] args) {

		//String클래스
		// > 한번 생성된 다음 변하지않는 문자열을 저장할때 사용
		String str = "play";
		System.out.println(str);
		
		str = "Life";
		System.out.println(str);
		
		
		//결론 : 문자열 객체가 생성되면 수정되지 않는다.
		// str = "Life"객체를 다시 지정했다면, str = "play"  문자열 객체는 그대로 남아있고,
		// 새로운 str = "Life"객체의 메모리를 생성한다.
		// 처음에 선언한 str = "play" 문자열객체 메모리는 어떻게 될까?
		// 사용되지않는 String객체 메모리는 가비지 컬렉션에 의해서 제거된다. 
		
		
		str = str + " and play";
		System.out.println(str);
		
		
		/*
			마찬가지로 String str변수에 문자열객체를 새롭게 생성하여 저장했으므로
			새로운 "Life and Play"문자열을 저장할 객체 메모리가 만들어지고..
			기존에 존재했던 "Play"문자열 객체메모리와 "Life"문자열객체메모리는
			가비지 컬렉션에 의해 제거되어 사라집니다.
			
			문제점 :  같은 String클래스의 참조변수 str에 문자열객체를 생성해서 저장할때마다 
					새로운 String객체메모리를 생성해서 저장하게되면 응용프로그램 개발시
					프로그램의 속도가 느려지게 된다.
					그래서 String클래스에 대한 객체를 생성해야 하는 경우는?
					한번 저장되어 변하지 않는 문자열이 존재할때만 String클래스에 대한
					String객체메모리를 생성해서 저장해서 사용하자
					
					
			//StringBuffer클래스에 대한 객체메모리
			 > 변할 수 있는 문자열을 저장할 용도의 객체메모리를 만들때 사용하는 클래스	(가변문자열)
	
		*/

		//"JAVA"문자열을 저장시킬 StringBuffer클래스에 대한 객체 생성
		
		StringBuffer sb = new StringBuffer("JAVA");
		
		//StringBuffer객체메모리에 저장된 "JAVA"문자열에 가변적으로 문자열을 추가할 수 있다.
		sb.append("Programming");
		
		System.out.println(sb.toString());
		//toString은 생략가능하다.
		
		//결론 :  생성된 StringBuffer문자열객체 내부에 저장된 문자열이 수정된다.
		//		새로운 StringBuffer문자열 객체가 만들어 지지 않고, 처음에 생성한 StringBuffer문자열객체의 내용이 수정되어 사용되므로.
		//		프로그램속도가 String객체메모리를 생성해서 문자열을 저장한것보다 더 빠르다.
		
	}

}
