public class outMoney extends Thread {
	private int money = 0;
	private MyAccount myAcct = null;
	
	outMoney(MyAccount acct, int m){
		myAcct = acct;
		money = m;
	}
	
	public void run(){
		myAcct.sub(money);
		System.out.println("�Ա�[-----] ���[" + money + "] �ܾ�[" + myAcct.getCurMoney() + "]");
	}
}
