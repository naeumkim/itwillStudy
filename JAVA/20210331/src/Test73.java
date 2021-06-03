
//클래스변수 인스턴스변수 클래스메소드 인스턴스메소드 만들기 연습


//상품클래스 Product만들기
	//상품명을 문자열로 저장할 클래스변수 modelName 만들기
	//상품의 단가를 정수로 저장할 클래스변수 unitprice 만들기
	//상품명과 단가를 하나의 문자열로 만들어서 출력할 기능의
	//클래스 메소드 print 만들기

class Product{
	
	static String modelName;
	static int unitPrice;
	
	static void print() {
		System.out.println(modelName + "," + unitPrice);
		
	}
	
	
}



//고객클래스 Customer만들기
	//고객명을 문자열로 저장시킬 인스턴스변수 name만들기
	//고객의 나이를 정수로 저장시킬 인스턴스변수 age만들기
	//기본생성자 만들기(비워두기)
	//새로운 고객명만 매개변수로 전달 받아 위 인스턴스변수에 초기화할 생성자 만들기
	//새로운 고객나이만 매개변수로 전달받아 위 인스턴스변수에 초기화할 생성자 만들기
	//인스턴스변수 name과 인스턴스 변수 age에 저장된 고객의 이름과 고객의 나이를 하나의 문자열로 만들어서 반환할 인스턴스 메소드 print만들기
		
class Customer{
	String name;
	int age;
	
	public Customer(){
	}
	
	Customer(String name){
		this.name = name;
		
	}
	
	Customer(int age){
		this.age = age;
	}
	
	
	//String print() {
	//return name + " , " + age;
	//}
	//위 인스턴스변수 name데이터와 인스턴스변수 age의 데이터를 하나의 문자열로 합쳐서 출력할 기능의 인스턴스메소드 print만들기
	void print() {
		System.out.println(name + "," + age);		
	}
	
	
	
}



public class Test73 {

	public static void main(String[] args) {
		//출력결과
		/*
			쉽게배우는자바,33000원
			------------------
			재벌1세,31
			재별2세,33
		*/
		//modelname,unitPrice클래스 변수의 값들을 각각 "쉽게 배우는 자바 ", 33000으로 저장
		Product.modelName = "쉽게 배우는 자바";
		Product.unitPrice = 33000;
		
		
		//print() 클래스 메소드 호출
		
		//쉽게배우는자바,33000 < 출력되게하기
		Product.print();
		
		//---------------- < 출력되게하기
		System.out.println("----------------------");
		
		
		
		//Customer클래스로부터 new  객체 생성! 참조변수이름 c1
		Customer c1 = new Customer();
		//재벌 1세,31을 각각 인스턴스변수에 저장
		c1.age = 31;
		c1.name = "재벌 1세";
		//print()인스턴스메소드 호출해서 재벌1세,31 < 출력
		c1.print();
		
		//Customer클래스로부터 new  객체 생성! 참조변수이름 c2
		Customer c2 = new Customer();
		//재별2세,33을 각각 인스턴스변수에 저장
		c2.age = 33;
		c2.name = "재벌 2세";
		//print()인스턴스메소드 호출해서 재벌2세,33 < 출력
		c2.print();
		
	}

}
