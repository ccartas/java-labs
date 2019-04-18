package ro.ase.java.threads;

public class ShoppingSync implements Runnable{

	private String name;
	public double account = 50;
	//private Object lock = new Object();
	
	private void withdraw(int sum) {
		synchronized (this) {
		if(account >= sum) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account -= sum;
		System.out.println(Thread.currentThread().getName() + " made a transaction synchronized. Balance left: " + account);
		}
			}
	
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<200;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				withdraw(i);
		}
			
		
	}

}
