

//지난 Test55.java 에 작성한 과일장수 이야기 업그레이드 시키기

//2단계.  클래스 설계도 만들기

//과일장수(판매자) FruitSeller클래스 만들기
class Fruitseller{

//변수선언
	
	//사과한개당 가격
	/*final*/  int APPLE_PRICE; /*= 1000;*/
	
	//보유하고 있는 사과 개수
	int numOfApple;
	//판매수익
	int Mymoney;
	
	
	//개발자가 생성자를 만들어 놓지 않으면 JVM은 기본 생성자를 자동으로 만들어 놓는다. 단 우리 눈에는 보이지 않는다.
	
	/*public Fruitseller() {
		
	}*/
	
	
	
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
	
	//추가할 메소드의 기능 : 과일 판매자의 처음 상태 값을 저장시킬 기능의 메소드 만들기
	void initMembers(int money, int applenum, int price) {
		
		Mymoney = money; //처음 가지고 있는 돈
		numOfApple = applenum; //처음 가지고 있는 사과의 개수 
		APPLE_PRICE = price; //사과 개당 가격을 처음에 초기화할 목적
		
	}
	
	
}//셀러 클래스




//과일구매자 FruitBuyer클래스 만들기

class FruitBuyer{
	//현재 소유한 과일을 저장할 변수
	int NumOfApple = 0;
	//현재 소유 금액
	int Mymoney = 10000; 
	
	//구매자가 여럿일수 있기때문에 값 설정을 원래는 값 설정을 하지 않는다.
	
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




public class Test59 {

	public static void main(String[] args) {
		//과일 판매자(과일 장수1)객체 생성
		Fruitseller seller1 = new Fruitseller();
		//과일 판매자 잔고: 0원 , 보유하고 있는 사과 개수 : 30 , 개당 가격: 1500
		seller1.initMembers(0, 30, 1500);
		
		
		//과일 판매자(과일 장수2)객체 생성
		Fruitseller seller2 = new Fruitseller();
		//과일 판매자 잔고: 0원, 보유하고 있는 사과 개수 : 20 , 개당 가격 : 1000
		seller1.initMembers(0, 20, 1000);
		
		
		//과일 구매자 객체 생성
		FruitBuyer buyer = new FruitBuyer();
		
		//과일 구매자 객체는 과일 판매자1 객체에게 4500원어치 사과를 구매하기 위해
		//과일 구매자 객체의 buyapple(FruitSeller seller, int money)메소드 호출시
		//과일 판매자 객체(new FruitSeller())를 매개변수로 전달하고.
		//과일 구매금액을 int money매개변수로 전달한다.
		
		buyer.BuyApple(seller1, 4500);
		
		//과일 구매자 객체는 과일 판매자2 객체에게 2000원어치 사과를 구매하기 위해
		//과일 구매자 객체의 buyapple(FruitSeller seller, int money)메소드 호출시
		//과일 판매자 객체(new FruitSeller())를 매개변수로 전달하고.
		//과일 구매금액을 int money매개변수로 전달한다.
				
		buyer.BuyApple(seller2, 2000);
		
		System.out.println("--------------- 과일 판매자의 현재 상황---------------");
		
		seller1.ShowSaleresult();
		
		
		//과일 구매자의 현재 상황 (잔고, 구매 후 보유하고 있는 과일 수 ) 출력
		System.out.println("---------------------과일 구매자의 현재 상황--------------------");
		
		buyer.ShowBuyResult();
				
		/*
		   이 프로그램의 문제점 2가지
		   1.과일장수1,2 객체를 생성하고 난 다음에 상태값초기화를 해야한다.
		    즉! 두줄에 걸쳐서 문장을 구성해야 하나의 객체 생성을 완료할수 있다.
		    
		    2. FruitSeller(과일장수) 클래스의
		    	변수 APPLE_PRICE의 final선언이 사라졌다.
		    	[final이 빠진 것이 왜 문제가 되는 것일까.]
		    	클래스 정의시 과일장수가 판매하는 사과 한개 당 가격은 변경되지 않는다는 가정을 두고
		    	인스턴스 변수 APPLE_PRICE를 final로 선언했었다.
		    	그러나 메소드 내에서 APPLE_PRICE가격을 초기화하려다 보니
		    	어쩔 수 없이 final선언을 강제로 삭제 시켰다.
		    	메소드는 여러번 호출 할 수 있으므로,
		    	initMember()메소드를 여러번 호출 한다면..
		    	객체가 다시 초기화 되는 실수를 범할 수도 있기때문에
		    	딱 한번만 호출되는 메소드를 사용해서 객체의 상태값을 단 한번만 초기화해서 생성해야함

		 이 프로그램의 문제점 해결방법 :  딱 한번만 호출되는 메소드의 종류인 ? 생성자 이용
		 
		 
		 
		 */
	
		
			
	}

}
