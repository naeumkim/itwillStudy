



public class Test34 {

	public static void main(String[] args) {
		
	//문제 : 0과 10사이의 짝수들의 합구하기
	
	//4바이트 크기의 정수값을 저장할 sum1변수 선언 후 저장
	int sum1 = 0;
		//for반복문을 이용! 초기식 > int j=0; 
		//				조건식 > j변수의 값이 10보다 작거나 같냐? 
		//				증감식 j변수에 저장된 값을 2씩 증가
		
	for(int j=0;j<=10;j+=2) {
		sum1 += j;
		System.out.println(j + " : " + sum1);
		
	}
	
	//반복 출력결과	
	/*
	 0:0
	 2:2
	 4:6
	 6:12
	 8:20
	 10:30 
	 
	 */
		
	System.out.println("----------------------------------");
	
	//문제:  for문을 이용하여 "Hello world"문자열을 10번 반복해서 출력해라
		
	
	for(int i=1;i<=10;i++) {
		
		System.out.println("Hello world");
		
	}
	
	System.out.println("for반복문을 빠져나옴");	
	System.out.println("-------------------------------");	
		
	//문제 : for문을 이용하여 1부터 10까지의 숫자중 홀수들의 합을 최종적으로 구해 한번만 출력
	//출력결과
	//총 합계는 25
	
	int sum = 0;
	for(int j=1;j<=10;j+=2) {
		sum += j;
		
	}
	System.out.println("총 합계는 "+ sum);
	System.out.println("---------------------------------------");
	//문제 : 1부터 100까지의 짝수합(2550) 출력
	int m = 0;
	
	for(int i=1;i<=100;i++) {
			if((i%2)==0) { //i변수에 저장되어 있는 값이 짝수라면? 
				//sum변수에 짝수값 누적
				m += i;
				
			}
		
	}
		System.out.println(m);
	
		
		
	System.out.println("--------------------------------");
	
	/*
	 	break문
	 	break문은 현재 위치에서 가장 가까운 반복문을 벗어나는데 사용하는 키워드
	 	주로 if문과 함께 사용되어 특정 조건식을 만족하면 반복문을 벗어나는데 사용하는 키워드
	 	
	 */
	
	//10번 반복하여 i변수값을 출력하고 i변수에 저장되는 값이 5가 될때 for반복문을 완전히 빠져 나가게 하기
	for(int i=0;i<10;i++) {
		if(i==5) {
			break; //for반복문 {}영역을 완전히 빠져나가게 하기
			
		}
		
		
		System.out.println(i);
		
	}
		
	System.out.println("-------------------------------------------");
	
	//문제 : for반복문을 이용하여 구구단 출력
	
	//단 제목 붙이기 표시
	for(int i=2;i<=9;i++) {
		
		System.out.printf("%6d", i);
//							System.out.printf("포맷형식", 출력할값);
//							%d > 정수 %6d(정수형 6자리까지 표현하겠다.)
//							%s > 문자열
	}
	System.out.println();
	
	
	for(int i=1;i<=9;i++) {//바깥쪽 for 행(세로)을 반복
		
			for(int j=2;j<=9;j++) { //안쪽 열(가로)를 반복
//				System.out.print(j + "X" + i + "=" + (j*i) + "     ");
				System.out.printf("%dX%d=%2d  ",j,i,(j*i));
			}//안쪽 for 닫는 기호
		//하나의 행이 완성될 때 줄바꿈 출력
			System.out.println();
	}//바깥쪽 for 닫는 기호
	
	
	
	System.out.println("---------------------------------------");
	
	
	/*
	 
	 *
	 **
	 ***
	 ****
	 *****
	 
	 */
	
	for(int i=1;i<=5;i++) { //5번 반복
		for(int j=1;j<=i;j++) {//i변수에 저장된 값 만큼 반복
			System.out.printf(" * ");
			
		}
		System.out.println();
		
	}
		
	
	
	System.out.println("--------------------------");
	
	for(int k=5;k<0;k--) {
		for(int l=1;l<=k;l++) {
			System.out.printf(" * ");
			
		}
		System.out.println();
	}
	
	
	
	
	
	
	}

}
