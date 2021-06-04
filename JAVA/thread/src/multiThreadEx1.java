
/* 2개의 다중 스레드(메인스레드 + 작업스레드)가 각각 두가지 작업 처리하게 하기*/


//메인스레드가 있는 클래스
public class multiThreadEx1 {
	
	static long startTime = 0;
	
	
	//메인스레드가 첫번째 작업을 처리함
	public static void main(String[] args) {
		//아래의 작업스레드에 대한 객체 생성
		MultiThreaddemo1 mtd = new MultiThreaddemo1();
		mtd.start(); //시작대기 후 run()메소드가 호출됨
		
		
		//싱글(주) 스레드 작업 시작 시간 저장
				//Systemt.currentTimemillis()메소드는 1970년 1월 1일부터 현재까지 경과한 시간을 long값으로 리턴하며,
				//밀리세컨(1/1000초값)으로 반환
				startTime = System.currentTimeMillis();
				/*
					1970년 1월 1일부터 현재까지 경과한 시간을 저장하는 이유는?
					작업을 할때 걸린시간으로 측정하기 위함이다.
				*/
				/*싱글(주) 스레드 작업1*/
				//10번 반복하면서 *을 1초에 한번씩 10번찍기
				
				
				
				
				for(int i=0;i<10;i++) {

					//싱글(주)스레드 1초 휴식
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.print("*");
					
				}//for
			
				//*찍기 작업1 소요시간(초) 구하기 : (별을 10번찍은 후의 현재시간 - 별을 10번찍기전 작업 1 시작시간) / 1000
				System.out.println("작업 1 소요시간 : " + (System.currentTimeMillis() - startTime)/1000 + "초");
		
	}

}


//작업(자식)스레드 역할의 클래스
 class MultiThreaddemo1 extends Thread{

	 //작업스레드가 두번째 작업을 처리함
	 //1초 간격으로 10번 반복하면서 # 출력
	 @Override
	public void run() {
		 for(int i=0;i<10;i++) {
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.print("#");
			 
		 }
		 
		 //#출력 작업2 후  걸린 소요시간 					#10번 출력 후의 현재시간 - #10번 출력하기전의 시작시간 / 1000
		  System.out.print("작업2 소요시간 : " + (System.currentTimeMillis()- multiThreadEx1.startTime / 1000) + "초" );
		 
		 
	 }//run
	 
	 
 }
 
 /*
 	결론 : 2개의 스레드(main,작업스레드)가 각각 하나씩 하나씩 작업을 할때 하나의 스레드가 휴식할때 다른 스레드가 작업을 하는 것을 알 수 있다.
 	
 
 
 
 
 */