
/*인터페이스 연습1*/

//MobilePhone 인터페이스 만들기
	//전화거는 기능을 정의 해놓을 sendCall 추상메소드 만들기, 리턴타입 boolean
	//전화받는 기능을 정의 해놓을 receiveCall 추상메소드 만들기, 리턴타입 boolean
	//문자보내는 기능을 정의 해놓을 sendSMS 추상메소드 만들기, 리턴타임 boolean
	//문자 받는 기능을 정의 해놓을 receiveSMS 추상메소드 만들기, 리턴타입 bollean

interface MobilePhone{
	public abstract boolean sendCall();
	boolean receiveCall();
	boolean sendSMS();
	boolean receiveSMS();
	
}

//MP3 인터페이스 만들기
	//음악 재생기능을 정의 해 놓을 play 추상메소드 만들기, 리턴타입 void
	//음악 정지기능을 정의 해 놓을 stop 추상메소드 만들기, 리턴타입 void

interface MP3{
	void play();
	void stop();

}

//음악 + 전화 기능을 넣을 MusicPhone 인터페이스 만들기 (MobilePhone, MP3) 인터페이스 상속받아 만들기
	//playMP3RingTone 추상메소드 만들기, 리턴타입 void

interface MusicPhone extends MobilePhone,MP3{
	//MobilePhone 인터페이스로 부터 상속받은 추상메소드
	//MP3로부터 상속받은 추상메소드
	
	void playMP3RingTone(); 
	
}


//PDA 클래스 만들기
 	//두개의 정수값을 매개변수로 전달받아 그 합을 int로 리턴하는 calculate 메소드 만들기


class PDA{
	
	 public int calculate(int a, int b) {
		
		return a+b;
	}
	
}


//SmartPhone 클래스 만들기 (PDA클래스 상속반고, MusicPhone 인터페이스 구현)
	//MP3인터페이스를 상속한 MusicPhone 인터페이스의 모든 추상메소드 재구현(오버라이딩)
		//play메소드에 재구현할 내용 > "음악재생" 출력
		//stop메소드에 재구현할 내용 > "재생중지" 출력
	//MobilePhone 클래스가 상속한 MusicPhone의 모든 추상메소드를 재구현(오버라이딩)
		//sendCall메소드에 재구현할 내용 > "전화걸기" 출력, true 리턴
		//receiveCall 메소드에 재구현할 내용 >  "전화받기" 출력, true 리턴
		//sendSMS메소드에 재구현할 내용 > "SMS보내기" 출력, true 리턴
		//receiveSMS메소드에 재구현할 내용 > "SMS받았다" 출력 true리턴
	//MusicPhone의 모든 추상메소드를 재구현(오버라이딩)
		//playMP3RingTone 메소드에 재구현할 내용 >  비워두기
	
class SmartPhone extends PDA implements MusicPhone{

	@Override
	public void play() {
		System.out.println("음악재생");
		
	}

	@Override
	public void stop() {
		System.out.println("재생중지");
		
	}

	@Override
	public boolean sendCall() {
		System.out.println("전화걸기");
		return true;
	}

	@Override
	public boolean receiveCall() {
		System.out.println("전화받기");
		return true;
	}

	@Override
	public boolean sendSMS() {
		System.out.println("SMS보내기");
		return true;
	}

	@Override
	public boolean receiveSMS() {
		System.out.println("SMS받았다");
		return true;
	}

	@Override
	public void playMP3RingTone() {

		
	}

	
	
	
} 

public class Test109 {

	public static void main(String[] args) {
		//smartPhone 객체 생성, 참조변수 이름 p
		SmartPhone p = new SmartPhone();
		
		
		/*
			출력결과
			철수가 SmartPhone을 구입하였다.
			영희에게 전화걸기
			철수는 영희가 지금 부재중..이라는 SMS받았다.
			화가난 철수는 최신음악을 들으려고 음악재생
		*/
		System.out.println("철수가 SmartPhone을 구입하였다. ");
		System.out.print("영희에게");
		p.sendCall();
		System.out.print("철수는 영희가 지금 부재중...이라는 ");
		p.receiveSMS();
		System.out.print("화가난 철수는 최신음악을 들으려고 ");
		p.play();
		
		
	}

}
