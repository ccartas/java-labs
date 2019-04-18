package ro.ase.java.threads;

public class ShoppingThread extends Thread{

	private String name;
	private static double amount=50;
	public static final Object lock = new Object();
	
	public ShoppingThread(String name) {
		super(name);
		this.name = name;
	}
	
	private  void withdraw(int sum) {
		//synchronized (lock) {
		if(amount >= sum) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		amount -= sum;
		System.out.println(Thread.currentThread().getName() + " made a transaction synchronized. Balance left: " + amount);
		}
		//}
	}
	
	public void run() {
		for(int i=0;i<50;i++) {
			synchronized(lock) {
				withdraw(i);		
			}
		}
	}
}
