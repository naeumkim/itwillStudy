import java.io.InputStream;
import java.io.InputStreamReader;

/*
	문자스트림 방식으로 입출력
	
	문자스트림방식의 최고 부모클래스
	- Reader추상클래스
	- Writer추상클래스
	
	문자스트림방식을 사용하는 이유?
	- 키보드로 부터 한글 입력시...인코딩이 되지 않는데, 바이트 스트림에서는 1바이트씩 처리하였다. 
		한글은 2바이트이기 때문에 한글이 깨지는 것이다. 
		그러나 문자 스트림 방식으로 데이터를 주고 받으면 문자스트림 방식은 2바이트씩 처리하기 때문에
		데이터를 자유롭게 읽어 들이거나 내보내는 과정의 속도가 빠르다.
	

*/
public class CharstreamEx01 {

	
	//바이트 스트림의 최고 조상 InputStream클래스 타입의 참조변수(매개변수)로 받아야 함.
	public static void streamTest(InputStream is) {
		
		//바이트 스트림 방식을 문자스트림 방식으로 바꾸는 이유?
		//> 1바이트 단위로 데이터를 읽어 들일게 아니라 2바이트(한문자)단위로 데이터를 읽어 들이기 위함이다.
		//장점 : 영문 뿐만 아니라 한글도 읽어 들일 수 있다.
		
		//InputStream객체를 InputStreamReader 객체 생성지 생성자로 전달해 저장(포장)
		InputStreamReader isr = new InputStreamReader(is);
		//InputStream 클래스의 주요 메소드
		//int read() : 한문자씩 데이터를 읽어 들이는 메소드
		
		try {
			//매개변수로 전달받아 포장한 InputStreamReader 스트림 객체를 이용하여 
			//키보드로 부터 입력 받은 데이터를 한문자(2바이트) 단위로 반복해서 읽어 들여 출력
			while(true) {
				//키보드로 부터 한문자(2바이트)단위로 반복해서 읽어 들이자
				int i = isr.read();
				//만약 키보드로 부터 입력받은 데이터 중 읽어들일 데이터가 존재하지 않으면 더 이상 읽어 들이지 않고 while문을 빠져 나감
				if(i == -1) {
					break;
				}
				//키보드로부터 입력 받은 한문자(2바이트) 단위로 출력
				System.out.print((char)i);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		//메소드 호출시, 바이트 방식으로 데이터를 주고 받을 수 있게 InputStream객체 전달
		streamTest(System.in);
		
		
		
	}

}
