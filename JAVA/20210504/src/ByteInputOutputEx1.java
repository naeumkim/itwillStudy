import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
	ByteArrayInputStream클래스
	ByteArrayOutputStream클래스 알아보자
	
	-1Byte 단위로 데이터를 읽어들이거나 출력하는게 아니라..
	배열단위로 묶어서 읽어들이거나 출력할 수 있게 도와주는 클래스들
	
	
	ByteArrayInputStream클래스의 생성자
	
		ByteArrayInputStream(byte[] buf)
		> 매개변수로 전달받는 배열크기 단위로 파일에 저장된 데이터를 읽어들일 수 있다.
		
	
	

*/


public class ByteInputOutputEx1 {

	public static void main(String[] args) throws IOException {

		//파일의 내용을 읽어들여서 바이트배열에 저장시키기
		
		//파일의 내용을 한 바이트씩 읽어들이기 위한 스트림 통로 객체 생성
		//단 읽어들일 파일이름은 키보드로부터 입력받자.
		FileInputStream fin = new FileInputStream("D:\\workspace_java2\\20210504\\src\\c.txt");
		
		//파일의 내용을 한바이트씩 읽어와 바이트 배열 크기단위로 파일에 데이터를 출력할 스트림 통로
		ByteArrayOutputStream bout = new ByteArrayOutputStream(); //출력스트림 통로
		
		//데이터를 한바이트씩 읽어서 저장하기 위한 100바이트크기의 배열 생성
		byte[] buff = new byte[100];
		
		
		//파일의 내용을 위의 byte[100]용량만큼 읽어오는데..
		//fileinputStream에서 읽어온 바이트수를 저장할 변수
		int cnt;
		
		
		//fileinputStream객체를 통해 파일로부터 위 buff배열 크기만큼 읽어들여 buff배열에 저장하고 읽은 개수를 반환함.
		while((cnt = fin.read(buff)) != -1) {//읽어올 데이터가 존재할때 반복
			
			//ByteArrayOutputStream의 write메소드를 이용하여
			//buff배열에 저장된 내보낼 전체 데이터,buffer배열 시작위치, 읽어온 바이트의 크기만큼 
			//buff배열에 저장된 데이터를 ByteArrayOutputStream메모리에 저장(출력)함.
			
			bout.write(buff, 0, cnt);
			
		}
		//지금까지 한일 > 파일에서 읽어 들인 내용을 바이트 배열 형태로
		//ByteArrayOutputStream메모리에 저장했다.
		
		//바이트 배열 형태로 저장시킨 메모리 공간 > ByteArrayOutputStream메모리에서 byte[] 배열 꺼내오기
		byte[] arr = bout.toByteArray();
		//꺼내온 byte[] 배열 크기 출력
		System.out.println(arr.length);
		//꺼내온 byte[]배열 안에 저장된 데이터 내용 출력
		System.out.write(arr, 0, arr.length);
		
		
	}

}
