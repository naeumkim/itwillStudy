
/*
 	2단계 클래스설계도 정의
 	3단계 객체생성 후 사용
 
 */

// 2단계 클래스설계도 정의
//생성할 클래스명 : Student
class Student{

	//클래스 내부의 변수들
	//1.학번을 4바이트 크기의 정수로 저장할 hakbun 변수 선언
	int hakbun;
	//2. 학생 이름을 문자열로 저장할 name변수 선언
	String name;
	//3. 학생의 국어점수를 4바이트 크기의 정수로 저장할 kor변수 선언
	int kor, eng, math;
	//4. 학생의 영어점수를 4바이트 크기의 정수로 저장할 eng변수 선언
	//int eng;
	//5. 학생의 수학점수를 4바이트 크기의 정수로 저장할 math변수 선언
	//int math;
	//클래스 내부의 메소드들 
	
	int sum () { //int값으로 리턴한다고 했으므로 void가 아닌 int sum
	//1.학생의 국어,영어,수학 점수의 총합을 구하는 기능의 메소드(sum) 선언
		
		
	 return kor + eng+ math;}
		// (리턴값: 학생의 총점수합을 int값으로 리턴, 매개변수 x)
	
	//2. 학생의 총점수의 평균을 구해 8바이트크기의 실수값으로 리턴하는 avg메소드 선언
	double avg() {
		
		//(매개변수 x,리턴값 : 총점수의 평균값)
	//return 	(kor + eng+ math)  / 3.0;
	return sum() / 3.0;
	} //double 값이므로 3.0으로 나눠줘야 한다. 

}//class


public class Test56 {

	public static void main(String[] args) {
		
		//3단계 위 2단계에서 정의한 클래스 설계도를 이용해 객체생성 후 사용
		
		//Student클래스를 이용해 객체 메모리 생성  > 생성 후 Student클래스 타입의 s변수에 저장
		Student s= new Student();
		
		//위 s변수에 저장된 student객체의 객체변수 (인스턴스변수) hakbun에 1저장
		s.hakbun = 1;
		//위 s변수에 저장된 student객체의 객체변수 (인스턴스변수) name에 홍길동 저장
		s.name = "홍길동";
		//위 s변수에 저장된 student객체의 객체변수 (인스턴스변수) kor에 100점 저장
		s.kor = 100;
		//위 s변수에 저장된 student객체의 객체변수 (인스턴스변수) eng에 85점 저장
		s.eng = 85; 
		//위 s변수에 저장된 student객체의 객체변수 (인스턴스변수) math에 90점 저장
		s.math = 90;
		 
		
		/*출력결과 
		  홍길동 총점 : 275
		  홍길동 평균 : 91.666666667
		 */ 
		System.out.println(s.name + " 총점 : " + s.sum());
		System.out.println(s.name + " 평균 : "+ s.avg());
		//-------------------------------------------------
		////Student클래스를 이용해 객체 메모리 생성  > 생성 후 Student클래스 타입의 s1변수에 저장
		Student s1 = new Student();
		
		//s1변수에 저장된 new Student(); 객체 메모리 내부에 있는 hakbun객체변수에
		//2저장
		s1.hakbun = 2;
		//name 객체변수에 이몽룡 저장
		s1.name = "이몽룡";
		//국어 95, 영어 80, 수학 95 저장
		s1.kor = 95;
		s1.eng = 80;
		s1.math = 95;
		/*출력 결과
		 2학번인 학생의 총점 : 270
		 2학번인 학생의 평균 : 86.666666667
		 */
		System.out.println(s1.hakbun + "학번인 학생의 총점 : " + s1.sum());
		System.out.println(s1.hakbun + "학번인 학생의 평균 : " + s1.avg());
		
		
	}

}
