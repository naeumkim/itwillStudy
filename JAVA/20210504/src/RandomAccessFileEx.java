import java.io.IOException;
import java.io.RandomAccessFile;

/*

	RandomAccessFile클래스
	
	-스트림통로는 원칙적으로 FIFO(FirstInFirstOut)순차적 방식이다..
	-원칙적으로는 FIFO순차적 방식이지만 임의적으로 파일에 저장되어 있는 데이터에 접근 할 수도 있음
	 임의적으로 파일에 접근하기 위한 RandomAccessFile클래스 장치를 제공함
	 
	 
	 java.lang.object
	 	java.io.RandomAccessFile
	 	
	 	RandomAccessFile클래스는??
	 	InputStream또는 OutputStream으로 부터 상속받지 않고..
	 	자체적으로 DataInput인터페이스와 DataOutput인터페이스의 메소드를 자체적으로 오버라이딩 받아 사용함
	 	
	 	-주요 메소드
	 	void seek(long pos)메소드 : pos위치를 지정해주면 위치의 데이터를 찾는다.

*/
public class RandomAccessFileEx {

	public static void main(String[] args) throws IOException {

		//주제 : double데이터들을 파일에 저장하자
		
		double[] data = 
			{2.0, 3.14, 5.7, 10.98, 15, 24 , 20.20, 15.89, 101.22, 28.55};
												//저장할 파일 경로, 읽기모드 r 쓰기모드 w 가능하게
		RandomAccessFile raf = new RandomAccessFile("D:\\random.txt", "rw");
		//확인하기 random.txt파일이 d드라이버에 만들어 졌는지 확인
		
		//위 data배열에 저장된 데이터를 random.txt파일에 출력(저장)
		for(int i=0;i<data.length;i++) { //data배열의 각 인덱스 위치에 저장된 데이터를 꺼내어서 random.txt파일에 write 쓰기
			raf.writeDouble(data[i]);
			
			
		}
		
		
		//테스트 확인하기
		//d:\\random.txt 파일열어 확인하기
		//@       @	퇡?@儆儆勁@%悤?(?.      @8      @4333333@/풀z?@YNz??<뚉儆勁
		//random.txt파일에 2진데이터가 저장된 것을 확인 할 수 있다.
		
		
		//8byte위치에 있는 데이터 찾기
		raf.seek(8); //3.14
		/*
		설명
		double[] data = 
		{2.0, 3.14, 5.7 .......}
		0~7	 8~15   16~23.....바이트의 위치에 있는 데이터
	
		
		꺼내기
		`*/
		System.out.println(raf.readDouble());
	
		//0바이트 위치에 있는 데이터 찾기
		raf.seek(0);
		
		//꺼내기
		System.out.println(raf.readDouble()); //2.0
		
		//24바이트 위치에 있는 데이터 찾기
		raf.seek(24);
		//꺼내기
		System.out.println(raf.readDouble());
		
		//자원해제
		raf.close();
		
		
		
	}

}
