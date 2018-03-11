package ro.ase;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello world ! I'm a runnable class run by thread " 
							+ Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable, "t1");
		
		t1.start();
	}
}


