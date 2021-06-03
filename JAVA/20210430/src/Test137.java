import java.util.Iterator;
import java.util.Vector;

/*
 주제 : vector 배열 내부에 저장된 객체(데이터) 검색과 삭제 연습
 
 참고 
  vector클래스 내부의 메소드
  
  	int indexof(object o)메소드
  	- 지정된 객체(데이터)가 vector배열내부에서 최초로 검출된 인덱스 위치번호를 반환
	데이터 검색한다 > 데이터가 처음나온 인덱스 번호를 반환해준다.
	
	 E(제네릭타입) remove(int index)메소드
	 -Vector배열내부에 지정된 인덱스 위치의 객체(데이터)를 삭제하는 메소드
	 
	 boolean remove(Object o)메소드
	 -메소드 오버로딩 됨.
	 -Vector배열내부에 최초로 검출(검색)된 객체(데이터)를 삭제하는 메소드
	 
	 boolean contains(OBject o)메소드
	 -Vector배열 내부에 매개변수로 전달받은 객체(데이터)가 포함되어 있으면 true 반환
	 포함되어 있지 않으면 false반환
 
 
 */


public class Test137 {

	public static void main(String[] args) {
		
		//컬렉션 API내부에 존재하는 Vector클래스에 대한 객체 생성
		
		Vector vec = new Vector();
		//기본생성자로 백터 배열객체를 생성하면 초기용량은 10칸, 데이터가 모두 저장되어 있는 상태에서 새로운 데이터를 추가하면
		//증가되는 용량은 1칸이다.
		
		double[] arr = new double[] {38.6, 9.2, 45.3, 6.1, 4.7, 1.6};
		
		
		for(int i=0;i<arr.length;i++) {
			
			//위 vector배열에 new double[]배열에 저장된 모든 데이터들을 꺼내어 추가(저장)
			vec.add(arr[i]);
		
		}
		
		
		//위 Vector객체 배열에 저장된 객체 데이터들을 반복해서 얻어 출력
		for(int i=0;i<vec.size();i++) {
			
			System.out.print(" " + vec.get(i));
			
		}
		
		
		//한줄 띄우기
		System.out.println();
		
		
		
		//Vector객체 배열 내부에 저장된 데이터 검색
	
		//1.검색할 데이터를 저장할 변수 선언 후 6.1저장
		double searchData = 6.1;
		
		//2.Vector객체배열에 접근하여 6.1이 저장되어 있는지 검색
		//6.1이 vector객체 배열에 저장되어있으면 6.1이 저장되어 있는 위치의 인덱스 번호 반환
		int index = vec.indexOf(searchData);
		
		if(index != -1) {//vector배열 내부에 검색한 6.1이 저장되어 있으면? 
			//(index변수에 저장되어 있는 값이 -1이 아니면? 검색한 데이터가 저장되어 있다는 뜻)
			System.out.println("검색 성공 검색한 " + searchData + "는? " + index + "번째 인덱스에 위치함");
				
		}else {//검색할 데이터인 6.1이 vector배열내부에 저장되어 있지 않으면.
			
			System.out.println("검색 실패, 찾는 데이터가 벡터 내부에 저장되어 있지 않음");
		}
		
		//------------------------------------------------------------------------------------
		
		//Vector객체 배열 내부에 저장된 데이터 삭제
		//1.삭제할 데이터를 저장할 변수를 선언하고 45.3저장
		double delData = 45.3;

		//2.Vector객체 배열 내부에 삭제할 데이터가 저장되어 있는지 판단해주는 메소드 호출하여 조건판단하기
		if(vec.contains(delData)) {
			
			//해당 delData변수의 값 45.3을 Vector객체 배열 내부에서 삭제
			boolean result = vec.remove(delData);			
			//result변수에 값이 true라면?
			if(result == true) {
				System.out.println("45.3 삭제 완료");
				//삭제완료 < 출력
			}else{//result변수의 값이 false라면?
				System.out.println("45.3 삭제 실패");
				//삭제실패 < 출력
			}
			
		}// 바깥 if
		
		
		//iterator 인터페이스를 구현한 자식배열객체에 vector배열에 저장된 모든 객체(데이터)를 꺼내어서 저장후
		//while문을 이용해 하나씩 출력하자.
		
		Iterator iterator = vec.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			
		}
		
		
		

	}

}
