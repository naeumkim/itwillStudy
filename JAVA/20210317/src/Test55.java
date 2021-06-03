
/*
 	과일장수이야기
 	
 	[현실 세계 상황 재연1]
 	"나는 과일장수에게 두개의 사과를 구매했다."
 	
 	객체 >  나, 과일장수, 사과
 	
 	
 	[현실세계 상황 재연2]
 	"나는 과일장수에게 2000원을 주고 두개의 사과를 구매했다."
 	해설 : 나라는 객체가 과일장수 객체로부터 과일객체를 구매하는 동작을 표현
	
			//[과일장수 객체 관점]
			 과일장수 객체는 사과를 팝니다.
			 >	팝니다 : 동작(기능)
			 
			 과일장수 객체는 사과20개, 오렌지 10개를 보유하고 있습니다.
			 >	사과20개, 오렌지10개 : 데이터(상태)
			 	
			 //참고 : 데이터(상태)는 변수에 저장
			  	 	행동(기능)은 메소드로 표현
			  	 	
			  	 	
			  	 	
			  	 	
//객체지향 프로그래밍 1단계 현실의 객체 모델링
	//과일장수객체모델링
	//데이터(상태) : 보유하고 있는 과일개수 100개, 과일 판매수익 10000원, 
	//행동(기능) : 과일 판매 행동, 거스름돈을 주는 행동

//객체지향 프로그래밍 2단계 클래스 설계
*/  

class FruitSeller{//과일 판매자
	//변수
	//사과 한개당 가격을 1000원으로 정해서 상수메모리에 저장, 고정 메모리는 final
	final int APPLE_PRICE = 1000; //상수명은 대문자로
	
	//보유하고 있는 과일 개수 100개를 저장할 변수 선언
	int NumofApple;
	// 과일 판매수익 10000원등을 저장할 변수 선언
	int myMoney;
	
	
	//메소드
	//과일 판매하는 행동을 메소드로 선언
	int saleApple(int money) { //과일 구매자가 과일 구매시 전달하는 금액을 매개변수로 받음
		//판매한 과일의 개수 구하여 저장
		//단! 과일 1개당 1000원이라고 가정
		int num = money / 1000;
		
		//과일 판매후 과일 개수 차감 후 NumofApple변수에 저장
		NumofApple -= num;
		//과일 판매 수익을  myMoney 변수에 누적
		myMoney += money;
		
		//실제 판매가 발생한 과일 수를 반환
		return num;
	}

	
	//과일 판매후 남은 과일 개수, 판매 수익(현재 과일구매자의 현재 상황) 출력 메소드
	public void showSaleResult() {
		System.out.println("판매하고 남은 사과개수 : "+ NumofApple);
		System.out.println("판매 후 잔고 : "+ myMoney);
		
	}
	
	
}//과일장수(과일판매자) 클래스 끝




/*	[과일 구매자 관점]
	1단계 나(과일구매자) 모델링
		데이터 > 현재 소유하고 있는 10000원, 현재 소유한 과일 수 0개
		동작(기능) > 과일을 구매하는 동작, 과일 구매 후 현재 상황 출력
								
								
	2단계 클래스 설계(정의) 
*/
class FruitBuyer{//과일 구매자 클래스 설계
	
	//변수
	//현재 소유하고 있는 10000원을 저장시킬 변수
	int myMoney = 5000;
	//현재 소유하고 있는 과일수를 저장할 변수 선언
	int NumofApple = 0;
	
	//메소드
	//과일 구매하기 행동의 메소드
	//매개변수 선언 > 과일을 구매하기 위한 과일판매자 객체를 전달하기 위한 매개변수 선언
	//매개변수 선언 > 과일구매하기 위한 구매금액을 전달할 매개변수 선언
	public void BuyApple(FruitSeller seller, int money) {
		//과일 판매자객체에게 과일을 구매하기 위해 매개변수 seller로 전달받은
		// new fruitSeller() 객체의 과일 판매행동의 메소드 호출시 금액을 전달함.
		//전달 후 구매한 과일 개수를 리턴 받아 > NumofApple변수에 누적
		NumofApple += seller.saleApple(money);
		
		//과일 판매자에게 과일 구매 후 현재 과일 구매자가 소유하고 있는 현금 계산
		myMoney -= money;
		
	}
	
	
	//과일 구매 후 과일 구매자의 현재 상황 출력가능의 메소드
public void showBuyResult() {
		System.out.println("과일 구매자의 현재 잔고 : " + myMoney);
		System.out.println("과일 구매자가 현재 보유한 과일 수  : "+ NumofApple);
	
	
	}
	
	
}//과일 구매자 클래스 끝



public class Test55 {

	public static void main(String[] args) {
	//3단계 위 2개의 클래스를 이용하여 객체 생성 후 사용
		//과일 판매자 클래스(FruitSeller클래스) 이용해 객체 생성
		
		FruitSeller seller = new FruitSeller();
		
		//과일 구매자 클래스(FruitBuyer) 이용해 객체 생성
		FruitBuyer buyer = new FruitBuyer();
		
		//과일 구매자가 과일 판매자에게 2000원을 지불하고 과일 구매하기
		
		buyer.BuyApple(seller, 2000);
		
		
		//과일 판매자의 현재 상황 ( 잔고, 팔고 남은 과일 수 ) 출력
		System.out.println("--------------- 과일 판매자의 현재 상황---------------");
		
		seller.showSaleResult();
		
		
		//과일 구매자의 현재 상황 (잔고, 구매 후 보유하고 있는 과일 수 ) 출력
		System.out.println("---------------------과일 구매자의 현재 상황--------------------");
		
		buyer.showBuyResult();
		
		
	}

}
