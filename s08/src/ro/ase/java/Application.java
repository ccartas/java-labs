package ro.ase.java;

import ro.ase.java.threads.Shopping;
import ro.ase.java.threads.ShoppingSync;
import ro.ase.java.threads.ShoppingThread;
import ro.ase.java.threads.simple.RunnableClassImplements;
import ro.ase.java.threads.simple.ThreadClass;

public class Application {
	public static void main(String[] args) {
		
//		//Test for class that extends Threads
//		ThreadClass t1 = new ThreadClass("Thread 1");
//		ThreadClass t2 = new ThreadClass("Thread 2");
//		t1.start();
//		t2.start();
//		
//		
//		//Test for class that implements Runnable
//		RunnableClassImplements r1 = new RunnableClassImplements();
//		Thread t3 = new Thread(r1, "Thread 3");
//		Thread t4 = new Thread(r1, "Thread 4");
//		t3.start();
//		t4.start();
//		
//		//Anonymous class
//		Runnable r2 = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println("Execution in thread " + Thread.currentThread().getName());
//			}
//		};
//		
//		Thread t5 = new Thread(r2, "Thread 5");
//		Thread t6 = new Thread(r2, "Thread 6");
//		
//		t5.start();
//		t6.start();
//		
//		//Lambda expression
//		
//		Runnable r3 = () -> {
//			System.out.println("Execution in thread: "+ Thread.currentThread().getName());
//		};
//		Thread t7 = new Thread(r3, "Thread 7");
//		Thread t8 = new Thread(r3, "Thread 8");
//		
//		t7.start();
//		t8.start();
//		
//		Shopping s1 = new Shopping();
//		
//		Thread wife = new Thread(s1, "Wife");
//		Thread husband = new Thread(s1, "Husband");
//		
//		husband.start();
//		wife.start();
//	
		ShoppingSync s2 = new ShoppingSync();
//		
		Thread wifeSync = new Thread(s2, "Wife Sync");
		Thread husbandSync = new Thread(s2, "Husband Sync");
		
		wifeSync.start();
		husbandSync.start();
		
		try {
			wifeSync.join();
			husbandSync.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		ShoppingThread t1 = new ShoppingThread("wife");
//		ShoppingThread t2 = new ShoppingThread("hubby");
//		
//		t1.start();
//		t2.start();
//		System.out.println("Main thread finished");
//		try {
//			t1.join();
//			t2.join();
//			
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		Shopping s1 = new Shopping();
//		Thread t1 = new Thread(s1);
//		Thread t2 = new Thread(s1);
		
		
	}
}
