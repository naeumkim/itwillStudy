
public class Test20 {

		public static void main(String[] args) {
			//if else if else 조건문을 이용한 예제
			
			
			//학생점수를 저장할 변수 score 선언후 45저장
			int score = 45;
			
			//학생점수에 따른 학점을 저장할 grade변수 선언후 기본값으로 초기화
			char grade = '\u0000';
			
			//조건식: 학생점수가 90점 이상이면? (score변수에 저장된 값이 90보다 크거나 같냐?)
			if(score >= 90) {
				
				grade = 'A'; // A학점 저장
			
			//조건식 : 학생점수가 80점 이상이면? (score변수에 저장된 값이 80보다 크거나 같으면?)
			}else if(score >= 80) {
				
				grade = 'B';
			
			//나머지 점수라면
			}else {
				grade = 'C';
			}
		
			System.out.println("당신의 학점은 " + grade + "입니다.");
			
			
			// 위 if  else if  else 조건문을 삼항조건연산자로 변경하기
			
		
			
			grade = (score>=90)? 'A' : ((score >= 80)? 'B' : 'C' );
			
			
			System.out.println("당신의 학점은 " +grade+ "입니다!");
			
			
		}
			
}