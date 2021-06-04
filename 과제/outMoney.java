public class outMoney extends Thread {
	private int money = 0;
	private MyAccount myAcct = null;
	
	outMoney(MyAccount acct, int m){
		myAcct = acct;
		money = m;
	}
	
	public void run(){
		myAcct.sub(money);
		System.out.println("입금[-----] 출금[" + money + "] 잔액[" + myAcct.getCurMoney() + "]");
	}
}
