import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
	printStream 클래스
	- 어떤 출력 장치와 관계없이 쉽고 간단하게 출력할 수 있게 해주는 메소드를 제공하는 스트림 클래스
	
	printStream클래스의 주요 메소드
	- print(), println(), printf()
	
	prinrStream클래스와 유사한 클래스?
	- 출력 스트림 전용 printWriter클래스 존재.
	
	
	주제 : printWriter클래스를 이용하여 print, printf메소드에 대하여 실습 해보자
	키보드로 부터 한줄씩 데이터를 입력 받아 파일에 저장(쓰기)



*/
public class PrintWriterEx01 {

	public static void main(String[] args) throws IOException {

		//키보드로부터 입력받은 데이터들을 한줄씩 읽어들이기 위한 스트림 통로 준비
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//1.파일에 문자스트림 방식으로 쓰기(저장)하기 위해 FileWriter 출력 스트림 통로 준비
		//2.성능향상을 위해 파일에 데이터 저장시 한문자씩 버퍼에 모아 두었다가 한줄단위로 데이터를 쓰기 위해 BufferdWriter객체로 다시 포장하여 출력스트림통로 준비
		//3.printWriter객체의 print,printf메소드등을 사용하기 위해 printWriter객체 생성시 
		//BufferedWriter 객체를 생성자로 전달해 다시 저장
		PrintWriter pw = 
		new PrintWriter(new BufferedWriter(new FileWriter("D:\\printWriterTest1.txt")));
		
		/*키보드로 부터 입력받은 데이터를 한줄 단위로 printWriterTest1.txt파일에 저장하는 작업
			키보드로 부터 입력 받은 데이터 한줄을 저장할 변수
		 */
		
		String line;
		
		//키보드로 부터 입력 받아 읽어들일 데이터가 존재하는 동안 반복
		while((line = br.readLine()) != null ) {
			//키보드로 부터 입력 받아 들인 데이터를 일단 이클립스의 console에 출력
			System.out.println(line);
			
			//실제 파일에 저장하기 위해 FileWriter객체의 writer메소드 대신..printWriter객체의 println메소드를 사용하여 파일에 저장
			pw.println(line);
			
		}
		//자원해제
		br.close();
		pw.close();
		
	}

}
