  

public class Test26 {
	
		//a라는 이름의 함수 정의 
		public static int a() { //a출력
			//System.out.println("a");
			
			return 100; //100을 돌려준다. a에는 100이 있는 것임.
			
		}
	
	
	

	public static void main(String[] args) {
		
		
		int a = Test26.a(); //test26 클래스 내부에 있는 a 함수 호출
		System.out.println(a);
		
		// Math라는 이름의 클래스 내부에는 random함수가 만들어져 있다.
		//random함수의 역할 : 0.0과 1.0사이의 난수를 double타입으로 생성하여 반환해줌
		//					(0.0은 범위에 포함되고 1.0은 포함되지 않는다.)
		
		//double num = Math.random(); //Math클래스에 random함수 호출 구문
									//random함수가 우리 개발자에게 되돌려 주는 값은?
									//0.0과  1.0사이의 난수를 되돌려준다.
		
		//System.out.println(num);
		
		//Math라는 클래스 내부에 있는 random() 함수를 호출하여 
		//숫자 1 ~10 사이의 수를 임의로 얻어내기
		
		int score =  (int)(Math.random()*10)+1; // (int)(Math.random()*최대값)+최소값
			System.out.println(score);
		
			
		/*
		 	중요!
		 		0.0 <= Math.random() < 1.0
		 	예)1~10사이의 랜덤 정수 
		 	순서1. 각변에 10을 곱한다.
		 			0.0	*10 <= Math.random()*10 < 1.0*10
		 			0.0		<= Math.random()*10 < 10.0
		 	
		 	순서2. 각변을 int형으로 변환한다.
		 		(int)0.0		<= (int)(Math.random()*10) < (int)10.0
		 				0		<= (int)(Math.random()*10) < 10
		 				
		 			지금까지는 0과 9사이의 정수 중 하나를 랜덤으로 구할 수 있다.
		 			(0은 포함,10은 포함안됨) 
		 				
		 	순서3. 각변에 1을 더한다. (1~10 랜덤값 추출을 위해)
		 			0+1		<= (int)(Math.random()*10)+1 < 10+1	
		 			1		<= (int)(Math.random()*10)+1 < 11
		 			(1 포함,11은 포함 안 됨)
		 			1과 10사이의 정수 중 랜덤한 하나의 값을 얻을 수 있다.
		 			
		 			
		 */
		
		
		//score 변수에 저장된 랜덤값에 100을 곱한 값과 일치하는 case절을 찾아서 실행
		switch (score * 100) {
			case 100:
				System.out.println("당신의 점수는 100점이고, 상품은 자전거입니다.");
				break;
			case 200:
				System.out.println("당신의 점수는 200점이고, 상품은 TV입니다.");
				break;
			case 300:
				System.out.println("당신의 점수는 300점이고, 상품은 노트북입니다.");
				break;
			default:
				System.out.println("꽝~ 다음기회에!");
				break;
		
				
				
				
		}
			
			

	}

}
