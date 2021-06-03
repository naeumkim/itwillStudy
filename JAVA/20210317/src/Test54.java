/*
  객체 지향 프로그래밍의 3단계
  1단계 현실에 존재하는 객체 모델링 (데이터, 동작 추출)
    푸들 객체
   데이터 : 황색털, 털길이 10cm, 다리길이100cm, 수컷, 종푸들
   동작 : 걷거나 뛴다, 짖는다, 주인을 알아보는 행동, 번식한다
   
   
  2단계 현실에 존재하는 객체의 데이터와 동작을 이용하여 클래스(설계도)만들기 
 */
class Puppy{
	
	String 종;
	String color; //black,brown
	String male; // male, female
	int leg; 
	int hair;
	
	void move(){
		System.out.println( 종 +"이 걷거나 뛴다.");
	} 
	
	void bowwow() {
		System.out.println(종 + "이 짖는다.");
	}
	
	
	void khow() {
		System.out.println(종 + "이 주인을 알아 본다.");
	}
	
	
}//puppy



public class Test54 {

	public static void main(String[] args) {
		//3단계 : 클래스 설계도를 참고하여 현실세계에 존재하는 객체들을 코드로 생성
		//푸들 객체 생성
		//1.puppy클래스 설계도를 바탕으로한 참조변수 선언
		Puppy poodle;
		//2. new연산자로 puppy클래스로 부터 객체메모리 생성 후 
		//		주소값을 poodle 참조변수에 저장
		poodle = new Puppy();
		//설명) poodle 참조변수에 생성된 객체메모리의 주소값이 들어있으므로 poodle참조변수명으로 생성된 객체메모리에 접근이 가능하다.
		//3. 생성된 객체에 데이터를 객체 내부의 변수에 저장
		//형식) 참조변수명.객체변수명 = 저장할 데이터
		
		poodle.종 = "푸들";
		poodle.color = "검정색";
		poodle.hair = 1;
		poodle.leg = 23;
		poodle.male = "female";
		
		//4. 푸들객체에 정의된 객체메소드를 호출하여 동작 시키기
		//형식) 참조변수명.객체메소드명();
		poodle.bowwow();
		poodle.khow();
		poodle.move();
		
		
		System.out.println("-----------------------------------------------------------");
		
		//3단계 객체 생성 연습
		//1.puppy클래스 설계도를 바탕으로한 참조변수 pome 선언
		Puppy pome;
		//2.new연산자로 객체 생성후 pome참조변수에 객체 주소값 저장
		pome = new Puppy(); // new ctrl + shift+ ;
		//3.생성한 객체에 각 객체변수에 데이터 저장
		//저장할 데이터
		//"포메라니안"
		//"흰색털"
		//털길이 10
		//다리길이 2
		//수컷
		pome.종 = "포메라니안";
		pome.color = "흰색";
		pome.male = "male";
		pome.leg = 2;
		pome.hair = 10;
		//4. pome참조변수에 저장된 객체 내부의 객체 메소드를 호출하여 동작시키기
		pome.bowwow();
		pome.khow();
		pome.move();
		
		//출력결과 
//		포메라니안이 짖는다.
//		포메라니안이 주인을 알아 본다.
//		포메라니안이 걷거나 뛴다.
		
		
	}//main

}
