package ro.ase;

public class MyThread extends Thread{
	
	public MyThread(String name) {
		super(name);
	}
	
	@Override
	public void run(){
		System.out.println("Hello " + Thread.currentThread().getName());
	}

	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new MyThread("t1");
		Thread myThread2 = new MyThread("t2");
		
		myThread.start();
		myThread2.start();
		
		System.out.println("Main program ended");
	}
	
}
