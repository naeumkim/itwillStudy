package exam;

class Exercise12_1 {

	public static void main(String[] args) {
			
		//Thread th1 = new Thread(new Thread1());
		
		Thread1 th = new Thread1();
		
		Thread th1 = new Thread(th);
		
		
		
		th1.start();
		
	}
}
	
	class Thread1 implements Runnable{
		
		@Override
		public void run() {
			for(int i=0;i<300;i++) {
				System.out.println('-');
			}
			
		}	
		
	}

		
	
	

