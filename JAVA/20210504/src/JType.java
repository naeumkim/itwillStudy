import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*

주제 : FileInputStream 클래스를 이용한 도스의 Type프로그램 만들기
도스로 실행하는 방법
예) DOS명령어 중에서 Type프로그램을 통해서 텍스트 파일의 내용을 읽어들일 수 있음.
방법
순서1)시작메뉴 크림 >cmd 관리자권한으로 실행
2) A.txt 파일이 있는 곳으로 이동 D:w(작대기 \) > D: 
3) type프로그램을 통해 A.txt파일의 내용을 읽어 도스창에 출력한다.
	소스 코드 type 텍스트 파일명 엔터
			type a.txt 

Dos의 Type프로그램과 유사한 JType프로그램을 만들어서 사용해보기


*/

public class JType {

public static void main(String[] args) throws FileNotFoundException ,IOException{
		/*
			주기억장치 : 프로그램은 실제 주기억장치에 존재한다.
						그러므로 실제 CPU는 주기억장치를 통해서 프로그램에 접근하여 사용함.
			
			보조기억장치(usb,외장하드) : CPU가 사용할 수 없는 파일이 들어있는 장치
			
			 결론 : CPU는 보조기억장치에 직접 접근할 수 없으므로 보조기억장치에 있는 파일을 주기억장치 메모리에 올려놓기(로드)위해..
			 		주기억장치 내부에 파일이 저장될 수 있는 메모리 공간 만들기
			 		> fileInputStream클래스에 대한 객체메모리 생성
			 		
			 주기억장치에 읽어오기위한 파일을 저장할 수 있는 메모리 공간을 마려하기위해 객체 생성
			 어떤 파일을 주기억장치에 올릴 것인가에 대해서 생성자 매개변수로 전달할 수 있는 방법
			 1번. 직접 파일을 불러 올 수 있는 주소를 적는 방법
			 2번. 명령인자를 통해 불러 올 수 있는 파일을 입력방는 방법
		*/
	
		//2번. 
		//우리가 입력한 파일의 내용을 바이트 단위로 읽어들일 스트링통로 객체 생성
		FileInputStream fis = new FileInputStream(args[0]);
		//메인메소드의 매개변수 String 배열 args를 넣는다
	
		//파일의 내용을 한바이트씩 읽어들여 저장할 변수
		int i;
		
		//한바이트씩 파일의 내용을 읽어들이기 위해 do while반복문 사용
		do {
			i = fis.read(); // 한바이트씩 읽어 들이기
			
			
			//만약 읽어들일 데이터가 존재한다면? (-1이 아니라면)
			if(i != -1) {
				 System.out.print((char)i);
					
			}
		
		
		}while(i != -1 );
			
	//FileInputStream객체 메모리 자원해제
		fis.close();
		
		
	}

	/*참고 : read()메소드의 반환값 -1이란?
	fileInputStream통로를 통해서 더이상 읽어들일 데이터가 존재하지 않으면 반환되는 값


	*/

}
