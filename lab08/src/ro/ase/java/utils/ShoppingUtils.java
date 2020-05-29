package ro.ase.java.utils;

public class ShoppingUtils implements Runnable {
	private double accountBalance;
	
	public ShoppingUtils(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public void withdraw(double amount) {
		if(this.accountBalance >= amount) {
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.accountBalance -= amount;
			System.out.println(Thread.currentThread().getName() + " made a transaction. New balance is: " + this.accountBalance);
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++) {
			this.withdraw(5);
		}
	}

}
