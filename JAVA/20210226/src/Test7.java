
public class Test7 {

	public static void main(String[] args) {
		//문제1. 자바의 기본 데이터 타입이 아닌 것은? 3
		// 1>byte
		// 2>double
		// 3>string
		// 4>boolean
		
		
		//문제2. 값이 365인 YEAR, 30인 MONTH, 7인 WEEK 정수(int)타입의 상수로 선언하라
		final int YEAR = 365;
		final int MONTH = 30;
		final int WEEK = 7;
		
		//문제3. 다음중 byte타입 변수에 대입 할 수 없는 값은? 1
		//1> 256
		//2> 127
		//3> 0
		//4> -99
		
		//문제4. 다음 수식의 결과 값은?
		//(byte)128 + (byte)128 + (int)22.9
		
		System.out.println( (byte)128 + (byte)128 + (int)22.9 );
		
		//문제5. 다음 각 항목이 나타내는 변수를 선언 하라.
		//(1) int형 변수 age
		int age = 0;
		//(2) 0.25로 값이 초기화된 float형 변수 f
		float f = 0.25f;
		//(3) age값과 f값을 더한 값으로 초기화된 double 변수 d
		double d = age + f;
		//(4) 문자 'a'의 유니코드로 초기화된 char형 변수 c
		char c = '\u0061';
		//(5) 자신의 이름으로 초기화된 문자열 변수 name
		String name = "김나은";
		
		//문제6. 다음 중 식별자 사용이 잘못된 경우를 모두 골라라
		
			/*
		
			int _i; 	가능
			
			int %j; 	불가능
			
			char 안녕; 	가능
			
			double lvar;	불가능(첫번째 숫자)
			
			char student_ID;	가능
			
			final int abcdefghijklmnopqrst; 가능은 하나 대문자로 작성할 것 
			
			*/
	
		
		//문제7. b라는 정수형 변수의 값과 100을 더해서 다시 b변수에 대입하는 자바문장을 작성하라.
		int b = 0;
			b = b + 100;
		//문제8. 자바의 기본데이터타입을 모두 나열하고 각 타입의 크기를 설명하라.
			

//	      boolean - 1byte 
//	      char -2byte 
//	      byte - 1byte 
//	      short - 2byte 
//	      int - 4byte 
//	      long -8byte 
//	      float - 4byte 
//	      double - 8byte
		 
		//문제9. 다음 수식의 결과 값과 타입은?
			
		//(1) 67 + 12.8 > 67.0d + 12.8d
		// double 79.8 결과값과 타입은 더블타입의 79.8	
		
		//(2) 'c' + 1  'c'는 char형이므로 2byte,아스키코드로 99
		// 'c' -> (int)'c' -> 99 + 1 = 100, 결과값과 타입은 int타입의 100
		//(3) 10 / 3
		//int타입 3 
		//(4) 10.0 / 3
		// 10.0/3.0의 결과값과 타입은 double타입의  3.3333333333333335 3이 15개	
		
			
	}

}
