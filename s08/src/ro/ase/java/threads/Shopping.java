package ro.ase.java.threads;

public class Shopping implements Runnable{

	private String name;
	public double account = 50;
	
	private void withdraw(int sum) {
		if(account >= sum) {
		try {
			Thread.currentThread().sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		account -= sum;
		System.out.println(Thread.currentThread().getName() + " made a transaction. Balance left: " + account);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<200;i++) {
			withdraw(5);
		}
	}

}
