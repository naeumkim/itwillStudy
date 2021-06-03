/*
 	연산자 문제 4)
 	
 	아래의 코드의 문제점을 수정해서 [실행결과]와 같은 결과를 얻으시오.
 	
 	[실행결과]
 	c = 30
 	ch = c
 	f = 1.5
 	l = 27000000000
 	result = true
 	
 
 */
public class Test17 {

	public static void main(String[] args) {

		byte a = 10;
		byte b = 20;
		//문제 byte c = a + b; //<-- 수정 후 이유를 주석으로 달기
		
		// 내 풀이 byte c = (byte)(a + b); // 10 +20는 int형으로 변하므로 형변환을 시켜줘야 한다. 때문에 (byte)(a+b);로 변경
		
		byte c = (byte)(a+b); // a변수값과 b변수값은 byte타입이므로 이항연산인 덧셈연산을 하기전에 int로 자동형변환된다. 
								// int 10 과 int 20을 덧셈 연산하므로 연산결과는 int 값이 된다. int타입의 값 (4byte)을 byte타입(1byte)
								// 변수에 담아야 하므로 형변환(byte)을 해주어야 한다.
		
		
		char ch = 'A';
		//문제 ch = ch + 2; // 수정 후 이유를 주석으로 달기
		
		// 내 풀이 ch = ch + (char)2; //모르겠습니다...
		ch = (char)(ch + 2); // 이유 : char타입이 덧셈연산의 과정을 거치면서 int타입으로 변환되므로 
							// char타입의 변수 ch에 저장하기 위해서는 (char)타입으로 형변환 해주어야 한다.
		
		
		
	
		
		
		//문제 float f = 3 / 2; // 수정 후 이유를 주석으로 달기
		
		//내 풀이 float f = (float)3/ (float)2; // 3과 2는 int 데이터형이다. int인채로 나눌 경우 소수점 자리가 버려지므로 float로 형변환이 필요하다.
		
		float f = 3/2f;
		//이유 int와 int의 연산결과는 int이기 때문에 3/2의 결과는 1이 된다. 연산결과를 실수값으로 얻고 싶으면. 
		//적어도 두 피연산자 중 한쪽이 실수타입(float,double)이어야 한다.
		
		
		//문제 long l = 3000 * 3000 * 3000; // 수정 후 이유 주석 쓰기
		
		//내 풀이 long l = (long)3000*(long)3000*(long)3000; // 3000*3000*3000는 int값이므로 long으로 형변환 필요
		
		long l = 3000 * 3000 * 3000l;
		
		//이유 int * int * int의 결과는 int타입의 최대값인 약 2*10의 9제곱을 넘는 결과는 오버플로우가 발생하여
		// 예상한 결과값과 다른 값을 얻는다. 그러므로 피연산자 중 적어도 한 값은 long타입이여야 최종결과를 long타입의 값으로 얻기 때문에,
		//long타입의 접미사 l을 붙여서 long타입의 리터럴로 만들어줘야 한다.
		
		
		
		float f2 = 0.1f;
		double d = 0.1;
		
		
		//내 풀이 double d = (float)0.1;
		//true로 반환하기 위해서는 0.1f로 형식이 동일해야함 형변환 시켜줘야 함...
		//boolean result = d == f2; //수정 후 이유를 주석으로 달기.
		
		boolean result = (float)d == f2;
		// 이유 비교연산자도 이항연산자이므로 연산 시에 두 피연산자의 타입을 맞추기 위해 형변환이 발생한다.
		// 그래서 double과 float의 연산은 double과 double의 연산으로 자동형변환되는데.
		// 실수는 정수와 달리 근사값으로 표현을 하기 때문에 float을 double로 형변환 했을 때 오차가 발생할 수 있다.
		// 그래서 float 값을 double로 형변환하기 보다는 double값을 유효자리수가 적은 float로 형변환해서 비교하는 것이 정확한 결과를 얻는다.
		
		
		
		
		System.out.println("c=" + c);
		System.out.println("ch=" + ch);
		System.out.println("f=" + f);
		System.out.println("l=" + l );
		System.out.println("result=" + result );
		
		
		
		
		
		
	}

}
