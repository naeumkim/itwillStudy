public class inMoney extends Thread {
	private int money = 0;
	private MyAccount myAcct = null;
	
	inMoney(MyAccount acct, int m){
		myAcct = acct;
		money = m;
	}
	
	public void run(){
		myAcct.add(money);
		System.out.println("�Ա�[" + money + "] ���[-----] �ܾ�[" + myAcct.getCurMoney() + "]");
	}
}
