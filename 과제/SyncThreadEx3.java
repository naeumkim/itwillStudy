public class SyncThreadEx3 {
	public static void main(String[] args) {
		MyAccount acct = new MyAccount(1000);
		
		new inMoney(acct, 10).start();
		new outMoney(acct, 100).start();
		new inMoney(acct, 50).start();
		new outMoney(acct, 900).start();
		new inMoney(acct, 10).start();
		new outMoney(acct, 100).start();
		new inMoney(acct, 500).start();
	}
}
