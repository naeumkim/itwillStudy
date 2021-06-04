public class MyAccount {
	private int totalMoney = 0;
	
	MyAccount(int money){
		totalMoney = money;
		System.out.println("계좌가 만들어 졌습니다. : " + totalMoney);
	}
	
	public synchronized void add(int money){
		this.notify();
		totalMoney += money;
	}
	
	public synchronized void sub(int money){
		if(totalMoney < money){
			try {
				System.out.println("잔액이 부족하여 우선 대기중...");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		totalMoney -= money;
	}
	
	public int getCurMoney(){
		return totalMoney;
	}
}
