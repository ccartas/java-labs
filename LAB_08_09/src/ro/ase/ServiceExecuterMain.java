package ro.ase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ServiceExecuterMain {
	private static int THREAD_POOL_NUMBER = 10;
	
	
	public static void main(String[] args) throws InterruptedException {
		 ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_NUMBER);

		 for(int i =0; i <200; i++){
			 MyCustonRunnable worker = new MyCustonRunnable("message" + i);
			 executor.execute(worker);
		 }
		 executor.shutdown();
		 executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		 
		 System.out.println("All threads are done");

	}
	
	

}
