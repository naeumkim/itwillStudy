
//switch 조건문 연습 문제1

public class Test25 {

	public static void main(String[] args) {
		
		
		int score = 1;
		
		switch (score * 100) {
		
		case 100:
			System.out.println("당신의 점수는 100이고, 상품은 자전거입니다.");
			
			
		case 200:
			System.out.println("당신의 점수는 200이고, 상품은 TV입니다.");
			
		
		case 300:
			System.out.println("당신의 점수는 300이고, 상품은 노트북 컴퓨터입니다.");
			
		
		case 400:
			System.out.println("당신의 점수는 400이고, 상품은 자동차 입니다.");
			

		default: 
			System.out.println("죄송하지만 당신의 점수에 해당하는 상품이 없습니다.");
			break;
		}
		
		/* 
		 	당신의 점수는 100이고, 상품은 자전거입니다.
		 	당신의 점수는 200이고, 상품은 tv입니다.
		 	당신의 점수는 300이고, 상품은 노트북 컴퓨터입니다.
		 	당신의 점수는 400이고, 상품은 자동차입니다.
		 	죄송하지만 당신의 점수에 해당하는 상품이 없습니다.
		 
		 
		 */

	}

}
