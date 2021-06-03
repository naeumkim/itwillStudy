import java.sql.PseudoColumnUsage;

//주제 : 여러개의 객체메모리를 만든 후 그 객체메모리들을 배열에 저장 시킬 수 있다.

//사람 클래스 만들기

class person{
	//변수
		//이름을 저장할 변수
		String name;
		//나이를 저장할 변수
		int age;
	//메소드
		//이름을 알려주는 기능의 메소드
		String getName(){
		return name;	
		}
	
}



public class Test57 {

	public static void main(String[] args) {
		
		//객체 배열이란?
		//생성된 객체메모리에 대한 주소번지를 원소로 갖는 배열
		//person[] pa = new person[10];  //만들때 클래스 이름이랑 같게 생성
		//new person() 객체 메모리들이 저장되어 있는 배열의 주소를 담을 pa 변수 선언  
		person[] pa 
		
		// new person()객체 메모리들을 저장할 배열메모리 생성 후 /배열 메모리의 주소를 pa 변수에 저장
		= new person[10]; 
		
		//pa변수에 저장된 new person[10]배열의 크기 만큼 반복해서
		//new person() 객체를 10번 생성 후 배열의 각 인덱스 위치에 저장
		for(int i=0;i<pa.length;i++) {
			//배열에 각 인덱스 위치에 새로운 new person() 객체 생성 후 (뉴펄슨 주소) 저장
			pa[i] = new person();
			
			//배열의 i변수에 저장된 인덱스 위치 번째에 존재하는
			//newperson() 객체내부의 age객체변수에 접근하여
			// 30 ~39 저장(1씩 증가시켜 저장 시키려 함)
			pa[i].age = 30 + i;
			
			
			
		}
		
		//배열에 각 인덱스 위치에 저장된 new person() 객체 내부의  age변수 값을 얻어 출력
		
		/*
		  배열의  0번째 인덱스 위치에 저장된 person객체1 객체변수age = 30
		  배열의  1번째 인덱스 위치에 저장된 person객체2 객체변수age = 31
		  배열의  2번째 인덱스 위치에 저장된 person객체3 객체변수age = 32
		  배열의  3번째 인덱스 위치에 저장된 person객체4 객체변수age = 33
		  .
		  .
		  .
		  배열의  9번째 인덱스 위치에 저장된 person객체10 객체변수age = 39
		 */

	
		for(int i=0;i<pa.length;i++) {
			
			System.out.println("배열의 " + i + "번째 인덱스 위치에 저장된  person객체" + (i+1) + " 객체변수age = " + pa[i].age );		
			
		}
		
	
	
	
	
	}

}
