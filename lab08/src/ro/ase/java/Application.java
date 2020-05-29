package ro.ase.java;

import ro.ase.java.utils.ShoppingUtils;
import ro.ase.java.utils.ShoppingUtilsSync;
import ro.ase.java.utils.SimpleRunnable;
import ro.ase.java.utils.SimpleThread;

public class Application {
	public static void main(String[] args) {
		SimpleThread st1 = new SimpleThread("Simple Thread 1");
		SimpleThread st2 = new SimpleThread("Simple Thread 2");
		
		st1.start();
		st2.start();
		
		
		SimpleRunnable sr1 = new SimpleRunnable();
		Thread t1 = new Thread(sr1, "Simple Runnable 1");
		Thread t2 = new Thread(sr1, "Simple Runnable 2");
		
		t1.start();
		t2.start();
		
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Executing thread: "+Thread.currentThread().getName());
			}
		};
		
		Thread t3 = new Thread(r1, "Anonymous Runnable 1");
		Thread t4 = new Thread(r1, "Anonymous Runnable 2");
		
		t3.start();
		t4.start();
		
		Runnable r2 = () -> {
			System.out.println("Executing thread: " + Thread.currentThread().getName());
		};
		
		Thread t5 = new Thread(r2, "Lambda Runnable 1");
		Thread t6 = new Thread(r2, "Lambda Runnable 2");
		
		t5.start();
		t6.start();
		
		/*ShoppingUtils utils = new ShoppingUtils(50);
		Thread t7 = new Thread(utils, "Wife");
		Thread t8 = new Thread(utils, "Husband");
		t7.start();
		t8.start();*/
		
		ShoppingUtilsSync utilsSync = new ShoppingUtilsSync(50);
		Thread t9 = new Thread(utilsSync, "Wife Sync");
		Thread t10 = new Thread(utilsSync, "Husband Sync");
		
		t9.start();
		t10.start();
	}
}
