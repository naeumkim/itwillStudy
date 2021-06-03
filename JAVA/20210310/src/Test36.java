
/*
 	변수 메모리 공간 : 하나의 이름으로 하나의 데이터형태의 값만 저장하는 그릇(단독주택)
 	
 	배열 메모리 공간 : 하나의 이름으로 하나의 데이터형태의 여러개 값을 저장해 놓는 메모리 공간(빌라)
 	
 	배열 메모리 공간의 특징
 	
 		1. 같은 데이터형태의 값들만 배열메모리 공간에 저장할 수 있다.
 		2. 기본 데이터형태의 값과 참조 데이터형태의 값 모두 저장 가능하다.
 		3. 배열메모리에도 이름을 붙여서 배열메모리에 접근하여 데이터를 관리 할 수 있다.
 		4. 배열메모리에 저장된 데이터의 갯수(배열의 크기) : 배열명.length; 사용
 		5. 배열메모리의 각 칸에 저장되어 있는 값을 가져와서 사용하는 방법
 			(배열의 각 요소에 접근하는 방법)
 			: 인덱스위치번호(첨자,배열번호)를 사용
 			
 		배열 메모리의 주소값을 저장할 변수만들기(배열 선언)
 		배열 메모리 만들기(배열 생성)
 		배열 메모리에 값 저장(배열 초기화)
 		하는 방법 2가지
 		1. new연산자를 이용하는 방법
 		2. 배열메모리 생성시 직접 값을 저장하여 만드는 방법
 */
public class Test36 {

	public static void main(String[] args) {
		
		//1.new연산자를 이용하는 방법(배열선언, 배열생성, 배열초기화)
		/*주제 : 학생 5명의 점수 관리*/
		//변수선언 및 점수 초기화
		int score1 = 50, score2 = 100, score3 = 80;
		int score4 = 90, score5 = 30;
		
		//배열메모리의 주소값을 저장할 변수만들기(배열선언) 방법 : 자료형[] 변수명;
		//1.배열 선언
		int[] score; // int정수값들이 저장될 배열 메모리의 주소번지를 저장할 score변수 선언 /배열 메모리로 쓸 변수 선언
		
		// 배열 메모리 만들기(배열 생성) 방법 : 변수명 =  new 자료형[배열크기]; 
		//2.배열 생성
		score = new int[5]; //int타입의 자료 5개를 저장할 배열 메모리 공간 생성
		
		//배열 메모리에 값 저장(배열 초기화) 방법 : 
		// 배열메모리의 주소가 저장된 변수명[인덱스위치번호] = 저장할 값;
		//3.배열 초기화
		score[0] = 50;
		score[1] = 100;
		score[2] = 80;
		score[3] = 90;
		score[4] = 30;
		
		//배열 메모리의 각 인덱스번호 위치에 저장되어 있는 값을 얻어 출력하는 방법
		//배열메모리의 주소가 저장된 변수명[인덱스 위치번호] > 인덱스 위치번호에 있는 값을 얻어 낸다.
		//4-1. 배열 메모리에 저장된 값을 얻어 출력(배열 요소 출력)
		
		System.out.println("1번 학생 :  "+ score[0]);
		System.out.println("2번 학생 :  "+ score[1]);//1 인덱스 위치에 있는 100을 꺼내어 얻어 출력
		System.out.println("3번 학생 :  "+ score[2]);//2 인덱스 위치에 있는 80을 꺼내어 얻어 출력
		System.out.println("4번 학생 :  "+ score[3]);
		System.out.println("5번 학생 :  "+ score[4]);
//		존재하지 않는 배열의 인덱스 번호 위치에 접근하려고 할 때 예외(에러) 발생
//		System.out.println("6번 학생 :  "+ score[5]);
		
		System.out.println("--------------------------------------------");

		//4-2. for반복문을 이용하여 배열 메모리에 저장된 각 값을 반복해서 얻어 출력
		for(int i=0;i<5;i++){
			 System.out.println((i+1)+"번 학생 : "+ score[i]);
			
		}
		
		
		System.out.println("--------------------------------------------");
		//1차원 배열메모리에 저장된 데이터의 갯수(배열 크기) 얻는 방법: 배열명.length;
		//5. 배열 크기 알아내기
		System.out.println("score배열메모리의 크기 : "+ score.length);
		
		//5-1. for반복문을 이용해서 배열메모리에 저장된 데이터들을 반복해서 얻어 출력(length사용)
		for(int i=0;i<score.length; i++) { //배열에 저장된 데이터의 갯수만큼 반복
			System.out.println((i+1) + "번 학생 : "+ score[i]);
			
		}
		
		
		
		
		
		
		                        
		
		
	
		
		
		
		
		
	}

}
