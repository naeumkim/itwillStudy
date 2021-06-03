import java.util.jar.Attributes.Name;

//문제 : 상품 하나를 표현하는 클래스 Goods를 작성하라.
/*
 상품은 Goods클래스로 표현되며 String타입의 name, 
 int타입의 price,numOfStock,sold 등 네개의 변수(필드)를 갖는다. 
 Goods클래스 내에 main()메소드를 작성하여 Goods객체를 하나 생성하고,
 이 객체에 대한 참조변수명은 camera로 하라
 그리고 나서 camera의 상품이름(name필드)을 "Nikon"
 가격(price필드)을 400000
 재고개수(numOfStock)를 30
 팔린개수(sold필드)를 50으로 설정 하라.
 그리고 설정된 이들 값들을 화면에 출력하라.
 
 
 출력결과
 상품이름 :  Nikon
 상품가격 : 400000
 재고수량 : 30
 팔린수량 : 50
 
 */



public class Goods {
	
	//변수(필드) 생성
	String name;
	int price, numOfStock, sold;
	

	public static void main(String[] args) {
		//객체 생성
		Goods camera = new Goods();
		camera.name = "Nikon";
		camera.price = 400000;
		camera.numOfStock = 30;
		camera.sold = 50;
		
		System.out.println("상품이름 : " + camera.name);
		System.out.println("상품가격 : " + camera.price);
		System.out.println("재고수량 : " + camera.numOfStock);
		System.out.println("팔린수량 : " + camera.sold);

	}

}
