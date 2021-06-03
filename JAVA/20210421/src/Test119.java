
public class Test119 {

	public static void main(String[] args) {
//String 클래스 내부에 만들어져 있는 equals()메소드 , subString() 메소드
		//equals(Object o)메소드 
		// : String객체 메모리에 저장된 문자열 데이터를 비교할때 호출하는 메소드
		//두 문자열이 같으면 true를 반환하고 두 문자열이 다르면 false를 반환
		
		System.out.println("서로 다른 문자열 비교하기");
		
		String str1 = new String("Coffee");
		String str2 = new String("House");
		
		
		if(str1.equals(str2)) {
			System.out.println("String객체메모리에 저장된 두 문자열은 같다.");
		}else {
			System.out.println("String객체메모리에 저장된 두 문자열은 다르다.");
		}
		System.out.println("--------------------------------------------");
		
		System.out.println("서로 같은 문자열 비교하기");
		String str3 = new String("House");
		
		if(str2.equals(str3)) {
			System.out.println("String객체메모리에 저장된 두 문자열은 같다.");
		}else {
			System.out.println("String객체메모리에 저장된 두 문자열은 다르다.");
		}
		
		
		//subString메소드 : 전체 문자열의 특정 문자열을 잘라내어 가져올때 사용
		//오버로딩된 subString메소드 2가지
		//subStirng(int arg0,int arg1) : 지정된 인덱스 위치에서 특정 인덱스 위치까지의 문자열을 잘라서 반환
		//subString(int arg0) : 지정한 인덱스위치에서 마지막 인덱스 위치까지의 문자열을 모두 잘라서 반환
		
		
		System.out.println("------전체 문자열의 특정 인덱스 위치의 문자열을 잘라내서 가져오기--------");
		
		String a  = new String("AndroidJSPJAVA");
		//					    0123456789
		String temp1, temp2;
		
		temp1 = a.substring(7);
		System.out.println("temp1 : " + temp1);
		
		
		
		//SubString 메소드 호출시 문자열을 잘라낼 문자의 시작인덱스 위치 7을 전달하고,끝 인덱스 위치 10을 전달하면
		//SubString메소드는 전체 "AndroidJSPJAVA" 문자열에서 
		//7인덱스 위치에 존재하는 j부터 시작해서
		//10이전 인덱스 위치인 9인덱스 위치에 존재하는 P문자까지의 문자열 JSP를 잘라내어 반환
		
		temp2 = a.substring(7, 10);
		System.out.println("temp2 : " + temp2);
		
		
		//String클래스 내부에 존재하는 trim,concat메소드
		
			//trim() 메소드
			//> 전체 문자열 양끝에 빈 공백만 제거해서 제거된 문자열을 반환
			//참고 : 전체 문자열 데이터의 중간에 있는 공백은 제거되지 않음
		
			System.out.println("---문자열의 양끝의 공백 제거----");
			
			String b = new String("        JA    VA     ");
			
			String temp3 = b.trim();
			
			System.out.println(temp3);
			
			//concat() 메소드
			//두개의 문자열을 연결하여 하나의 문자열로 만들어서 반환
			// 사용법
			// (앞)연결할문자열객체.concat((뒤)연결할문자열객체)
			
			System.out.println("-----concat메소드를 이용하여 문자열 하나로 합치기-----");
		
			String c = "JAVA";
			String d = new String("PG");
			
			String temp4,temp5;
			
			temp4 = c.concat(d);
			System.out.println("temp4 : " + temp4); //JAVAPG
			
			temp5 = c + d;
			System.out.println("temp5 : " + temp5); //JAVAPG
			
			
			
			//String 클래스 내부에 만들어져 있는 contains메소드 , replace 메소드
				
				//contains메소드
				//> 전체 문자열에 원하는 문자열이 포함되어 있는지 확인하기 위한 메소드로 호출하면
				// 포함되어있으면 true 리턴, 없으면 false를 리턴한다.
			
			String e = new String("필요없는문자열해당문자열필요없는문자열");
			System.out.println("해당문자열이 포함되어 있는가? > " + e.contains("해당문자열"));
			System.out.println("'문자열'이 포함되어 있는가? > " + e.contains("문자열"));
			System.out.println("'JAVA'문자열이 포함되어 있는가? > " + e.contains("JAVA"));
			
			//결론 : public boolean contains(CharSequence s)메소드
			//매개변수로 CharSequence클래스 타입의 매개변수 s인데, 사용법은
			//"String" 문자열 객체를 전달하여 사용하면 된다.
			// > 아무리 긴문자열에도 우리가 원하는 단어가 포함되어 있는지 찾을 수 있게 도와주는 메소드
			
			//replace메소드
			// > 전체 문자열에서 우리가 원하는 단어를 찾아, 바꾼 후 그 바뀐 문자열을 리턴해주는 메소드 
			// > 오버로딩된 replace메소드 종류
			
			// replace(char oldchar, cha newchar)
			// >문자 단위로 변경시켜주는 메소드
			
			//replace(charSequence targer, charSequence replacement)
			// > 문자열 단위로 변경시켜주는 메소드
			
			//대소문자 구분함 
			
			String f = new String("JAVAJSPC");
			//"JAVASPC" 전체문자열 중에서 C문자만 !문자로 바꾼후 바뀐 전체 "JAVAJSP!"문자열을 반환
			System.out.println("문자단위로 변경 > " + f.replace('C', '!'));
			
			//바뀐 "JAVAPROGRAMING"문자열을 반환
			System.out.println("문자열단위로 변경 > " + f.replace("JSPC", "PROGRAMING"));
			
			//String클래스 내부에 만들어져 있는 그밖의 메소드들
			
				//String tolowerCase() 메소드
				// >  String객체메모리에 저장된 전체문자열의 모든 문자를 소문자로 바꿔 반환해주는 메소드
			
				//String toUpperCase()메소드
				// >  String객체메모리에 저장된 전체문자열의 모든 문자를 대문자로 바꿔 반환해주는 메소드
			
				//static String valueOf(Object obj)메소드
				// > 매개변수로 전달받는 데이터를 무조건~ 문자열객체로 변환해서 반환하는 메소드 
			
				String value = String.valueOf(false);
				System.out.println(value); //false
				
				value = String.valueOf(10); // > 숫자를 문자열로 변환해서 반환!
				System.out.println(value); // "10"
		
				
				//참고* 숫자형태의 문자열 "1000"을 숫자 1000으로 변환해서 반환해주는 메소드
				int value1 = Integer.parseInt("1000");
				System.out.println(value1); //숫자 1000
				
				
				/*
					<input type="text"  name="age">
					requeste.getparameter("age"); > 100
					
					parameter는 String값으로 반환해준다. 
					100+1 연산을 해야 한다면, 문자열100을 숫자로 변환해서 계산해야한다.
				
				*/
				
			
			
			
			
			
			
	}

}
