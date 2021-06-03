

//Animal클래스 만들기 
class Animal{
//변수
	//동물의 이름을 문자열로 저장할 name 변수 선언
	String name;
	//동물의 나이를 정수로 저장시킬 age변수 선언
	int age;
	//기본 생성자
	Animal() {
		//name변수에 "개" 저장
		name = "개";
		//age 변수에 3 저장
		age = 3;
	}
	
	Animal(String n_name){
		//동물의 이름을 n_name매개변수로 전달 받아 name변수에 저장할 생성자
		//name변수에 n_name매개변수로 전달받은 이름을 저장
		//age변수에 1저장
		name = n_name;
		age = 1;
	}
	
	Animal(int n_age){
	
	//동물의 나이를 n_age매개변수로 전달 받아 age변수에 저장할 생성자
		//name변수에 "동물" 저장
		//age변수에 n_age매개변수로 전달 받은 나이 저장
		name = "동물";
		age = n_age;
	}
	
	Animal(String n_name, int n_age){
	//동물의 이름과 나이를 매개변수로 전달 받아 name변수와 age변수에 각각 저장할 생성자
		//name 변수에 n_name매개변수로 전달 받은 이름 저장
		//age변수에 n_age매개변수로 전달 받은 나이 저장
		name = n_name;
		age = n_age;
	
	}

	//메소드
	//name변수에 새로운 값을 전달 받아 저장할 용도의 메소드
	void setName(String n_name) {
		name = n_name;
	}
	//age변수에 새로운 값을 전달받아 저장할 용도의 메소드
	void setAge(int n_age) {
		age = n_age;
	}
	
	
	//name 변수에 저장된 값을 반환해주는 메소드
	String getName(){
		return name;
	}
	
	
	//age 변수에 저장된 값을 반환해주는 메소드
	int getAge() {
		return age;
	}
	
	
	//name변수에 저장된 동물이 뛴다 < 출력하는 기능의 메소드
	void run() {
		
		System.out.println(name + " 뛴다." );
		
	}





}//Animal class


public class Test62 {

	public static void main(String[] args) {
		
		//출력할 내용
		/*
		 개 뛴다.
		 고양이 뛴다.
		 사자 뛴다.
		 10
		 ======================
		 토끼 뛴다.
		 2
		 기린 뛴다.
		 4
		 */
		
		
		Animal a = new Animal();
		a.run(); 
		a.name = "고양이";
		a.age=5;
		a.run();
		a.name = "사자";
		
		
		System.out.println(a.getName());		
		System.out.println(a.getAge());		
		
		
		Animal a2 = new Animal("토끼");
		a2.run();
		
		Animal a3 = new Animal(2);
		System.out.println(a3.getName());
		
		//Animal a4 = new Animal("기린",4);
		
		
		System.out.println("====================내 풀이====================");
		
		
		Animal N = new Animal("개");
		N.run();
		// setName,setAge메소드 이용하여 수정 
		N.setName("고양이");
		N.run();
		N.setName("사자");
		N.run();
		
		Animal AGE = new Animal(10);
		System.out.println(AGE.age);

		
		System.out.println("===============");
		N.setName("토끼");
		N.run();
		AGE.setAge(2);
		System.out.println(AGE.age);
		N.setName("기린");
		N.run();
		AGE.setAge(4);
		System.out.println(AGE.age);
		
	}

}
