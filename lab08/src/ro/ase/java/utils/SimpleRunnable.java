package ro.ase.java.utils;

public class SimpleRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Execting thread: " + Thread.currentThread().getName());
	}

}
