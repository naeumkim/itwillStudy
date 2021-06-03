
//연습 : super키워드를 이용하여 부모클래스의 멤버 및 생성자를 호출하는 연습


class Employee{
	String name;
	int salary;
	
	//사원의 이름과 급여를 하나의 문자열로 만들어 반환할 getEmployee 메소드
	public String getEmployee() {
		 return this.name + ", " + this.salary;	
	}
	
	
	//기본 생성자 비워두기
	public Employee() {

	}
	
	//사원의 이름과 급여를 매개변수로 전달 받아, 초기화 하는 생성자
	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
		
	}
	
	
}

//Employee클래스를 상속받는 새로운 Manager자식 클래스 만들기

	//부서명을 문자열로 저장시킬 depart변수 선언
	
	//name,salary,depart 변수의 데이터들을 하나의 문자열로 만들어서
	// 반환할 getManager()메소드 만들기

	//name과 salary그리고 depart변수의 값을 초기화하는 생성자

class Manager extends Employee{
	String depart;
	
	 public String getManager() {
		 return name + ", " + salary + ", " + depart;
		 
	 }
	
	 
	//name,salary,depart변수의 값을 초기화하는 생성자
	// > manager 객체 내부에 있는 name인스턴스 변수와 salary인스턴스는 상속받아 사용하므로, 
	//Employee객체의 생성자를 다시 호출해 super(name, salary)에 넘겨주어 Employee객체 생성자에서 
	//직접 변수의 값을 초기화 시켜야한다.
	public Manager(String name, int salary, String depart) {
		super(name, salary);
		this.depart = depart;
		
	}

	 
	 
}

public class Test90 {

	public static void main(String[] args) {
	//Employee 객체 생성시 생성자로 "홍길동", 2000을 전달하여 변수값 초기화
	//참조변수이름 emp
	Employee emp = new Employee("홍길동", 2000);
    //Manager객체 생성시 생성자 호출 "이순신", 4000, "개발"을 전달하여 변수값 초기화
	//참조변수 이름 man
	Manager man = new Manager("이순신", 4000, "개발");
	
	

	System.out.println(emp.getEmployee());
	System.out.println(man.getManager());
		
	/*
		출력결과
		홍길동, 2000
		이순신, 4000, 개발
	
	*/
	}

}
