
public class Test30 {

	public static void main(String[] args) {
		//예제 : 숫자 10부터 1씩 감소시키면서 숫자값을 반복 출려하는 예제
		
		int i = 10;
		while (i>=0) { //i변수에 저장된 값이 0이상일 때까지 반복문
			System.out.println(i--);
			
		}
		//i--의  --는 후위형 감소연산자이기때문에 i변수의 값이 출력된 후에 1감소한다.
		
		System.out.println("--------------------------------");
		
		// i=2 j=1 / i=2 j=2
		
		//예제 : while 반복문을 사용해서 구구단을 반복해서 출력하는 예제
		
		i = 2;
		
		while(i<=9) { //바깥쪽 while반복문
			
			int j = 1;

			while(j <=9) { //안쪽 while반복문
					
					System.out.println(i + "X" + j + "=" + i*j);
					j++; //곱하는 수 1씩 증가 해주어야 한다.
					
				}

			i++; // 2단..9단을 표현하기 위해 i변수값을 1씩 증가
			
		}
		
	
		
		
		
		
		}
		
	}

