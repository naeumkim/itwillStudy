

//지난 Test59.java 에 작성한 과일장수 이야기 
//생성자 이용하는 방법으로 업그레이드 시키기

/*
  FruitSeller(과일장수) 클래스 내부 수정
 	1. 사과 한개당 가격 저장할 APPLE_PRICE변수에  final을 붙이자.
 	2. 추가한 initMembers메소드 삭제.
 	3. 판매수익, 사과보유개수, 사과 개당 가격을 변수에 저장시킬 생성자 추가.
 
 */


//2단계.  클래스 설계도 만들기

//과일장수(판매자) FruitSeller클래스 만들기
class Fruitseller{

//변수선언
	
	//사과한개당 가격
	final int APPLE_PRICE;
	
	//보유하고 있는 사과 개수
	int numOfApple;
	//판매수익
	int Mymoney;
	
	
	
	//개발자가 생성자를 하나 만들어 놓으면, JVM은 기본 생성자를 만들어 놓지 않기 때문에, 개발자가 직접 기본생성자를 만들어 놓아야 한다.
	
//	  public Fruitseller() { this.APPLE_PRICE = 0;
//	  
//	  }
//	 
	
	
	//생성자 생성
	//new 객체 생성하는 동시에.. 호출되는 생성자 만들기
	//생성자의 역할 : 판매수익,사과보유개수,사과 한개당 가격을 각 변수에 저장
	//변수 생성 후 생성자 만드는 단축키 source > generate constructor using field (alt+shift+s , o)
	
	
	public Fruitseller(int aPPLE_PRICE, int numApple, int mymoneys) {
		
		APPLE_PRICE = aPPLE_PRICE; // 사과 한개당 가격을 상수에 저장
		numOfApple = numApple; //사과 보유 개수 변수에 저장 
		Mymoney = mymoneys; //과일장수가 현자 가지고 있는 돈을 Mymoney변수에 저장
	}
	
	
	
	
//사과 판매 행동의 메소드

	int SaleApple(int money) { //사과 구매자로부터 받은 돈을 매개변수로 얻는다.
		
		//판 사과 개수 구하기 = 사과 구매자로부터 받은 금액 / 사과 한개당 가격
		int num = money / APPLE_PRICE;
		
		//사과 판매 후 사과 판매자가 보유하고 있는 사과 수 
		numOfApple -= num;
		
		//사과 판매 후 판매수익 누적
		Mymoney += money;
		
		//실제 판매(구매)가 발생한 사과 개수를 리턴
		return num;
	}
	//사과 판매후 남은 사과 개수, 판매수익(과일판매자의 잔고)을 출력하는 기능의 메소드 
	void ShowSaleresult() {
		
		System.out.println("남은 사과 개수 :" + numOfApple);
		System.out.println("판매 수익 :"+ Mymoney);
		
	}
	

	
	
}//셀러 클래스


/*
 FruitBuyer(과일구매자) 클래스 내부 수정
 1.현재 소유하고 있는 현금 0원, 현재 소유하고 있는 사과 수 0개로 저장
 2.객체 생성 시 구매자가 현재 소유하고 있는 현금,사과 보유 개수를 저장할 생성자 추가

*/

//과일구매자 FruitBuyer클래스 만들기

class FruitBuyer{
	//현재 소유한 과일을 저장할 변수
	int NumOfApple; //값을 저장하지 않으면 기본으로 0저장
	//현재 소유 금액
	int Mymoney;
	
	
	//생성자
	//new FruitBuyer(10000); 객체 생성시...
	//또는
	//new FruitBuyer(20000); 객체 생성시...
	//현재 소유금액을 생성자의 매개변수로 전달해서 위 int mymoney변수에 저장할 생성자 추가
	//생성자 단축키 : alt + shift + s ++ o
	
	//구매자가 여럿일수 있기때문에 값 설정을 원래는 값 설정을 하지 않는다.
	
	public FruitBuyer(int numOfApple, int mymoney) {
		NumOfApple = numOfApple;
		Mymoney = mymoney;
	}

	//과일 구매기능의 메소드
	//매개변수 : 과일을 구매하기 위한 판매자 대상 객체를 전달 받은 변수
	//			과일 구매시 지불할 금액을 전달받을 변수
	void BuyApple(Fruitseller seller, int money) {
		
		//과일 판매자 객체(Seller참조변수활용)에게 과일을 구매하기 위해
		//과일 판매자 객체의 SaleApple(int money)메소드 호출시..돈을 전달 함.
		//그리고 과일 판매자가 판매한 사과 개수를 반환 받아옴.
		
		
		//과일 구매자객체 관점에서 구매한 사과 개수를 현재 자신이 소유하고 있는 사과개수에 누적
		NumOfApple += seller.SaleApple(money);
		
		//과일 구매자객체 관점에서 과일 구매 후 돈을 지불했기 때문에 지갑에서 돈이 차감되어야 한다.
		Mymoney -= money; 
	
	}	 
	
	//과일 구매 후 과일 구매자의 현재 남은 돈과 현재 가지고 있는 사과 개수를  출력
    void ShowBuyResult(){
    	System.out.println("현재 남은 돈 : "+ Mymoney);
    	System.out.println("현재 가지고 있는 사과 개수 : "+ NumOfApple );
    	
    }
	
}//바이어 클래스




public class Test64 {

	public static void main(String[] args) {
		//과일 판매자(과일 장수1)객체 생성
		//new 객체 생성시..판매수익,보유하고 있는 사과수, 개당 가격을 객체변수에 초기화할 생성자 호출
		Fruitseller seller1 = new Fruitseller(1500, 30, 0);
		
		//과일 판매자(과일장수)2 객체 생성
		//new객체 생성시...판매수익 0,보유 사과수 20, 개당가격 1000을 객체변수에 저장시킬 생성자 호출
		
		Fruitseller seller2 = new Fruitseller(1000, 20, 0);
		
		//과일 구매자 객체 생성과 동시에..객체변수의 값을 초기화할 생성자 호출
		//생성자 호출 > 과일 구매자의 현재 소유하고 있는 현금세팅으로 위해 10000원 전달
		FruitBuyer buyer1 = new FruitBuyer(0,10000);
		
		//과일 구매자 객체는 과일장수1객체에게..4500원어치 사과 구매하기
		buyer1.BuyApple(seller1, 4500);
			
		//과일 구매자 객체는 과일장수2객체에게...2000원어치 사과 구매하기
		buyer1.BuyApple(seller2, 2000);
		
		
		
		System.out.println("--------------- 과일 판매자1의 현재 상황---------------");
		
		seller1.ShowSaleresult();
		
		System.out.println("--------------- 과일 판매자2의 현재 상황---------------");
		
		seller2.ShowSaleresult();
		
		
		//과일 구매자의 현재 상황 (잔고, 구매 후 보유하고 있는 과일 수 ) 출력
		System.out.println("---------------------과일 구매자의 현재 상황--------------------");
		
		buyer1.ShowBuyResult();
		
	}

}
