public class MyAccount {
	private int totalMoney = 0;
	
	MyAccount(int money){
		totalMoney = money;
		System.out.println("���°� ����� �����ϴ�. : " + totalMoney);
	}
	
	public synchronized void add(int money){
		this.notify();
		totalMoney += money;
	}
	
	public synchronized void sub(int money){
		if(totalMoney < money){
			try {
				System.out.println("�ܾ��� �����Ͽ� �켱 �����...");
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
