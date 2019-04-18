package ro.ase.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import ro.ase.java.callable.ArrayTaskFuture;
import ro.ase.java.runnable.ArrayTask;

public class Application {
	static final int NUMBER_OF_THREADS = 5;
	
	public static void main(String[] args) {
		int[] vals = new int[1000];
		for(int i=0;i<1000;i++) {
			vals[i] = (int) Math.round(Math.random()*100);
			System.out.println(vals[i]);
		}
		
		
		
		ArrayTask[] tasks = new ArrayTask[NUMBER_OF_THREADS];
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		
		for(int i=0;i < NUMBER_OF_THREADS; i++) {
			int startIndex = i * (1000/NUMBER_OF_THREADS);
			int endIndex = (i+1) * (1000/NUMBER_OF_THREADS);
			
			tasks[i] = new ArrayTask(vals, startIndex, endIndex);
			executor.execute(tasks[i]);
		}
		
		
		ExecutorService threadPoolFuture = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		Future<Long>[] futureValues = new Future[NUMBER_OF_THREADS];
		for(int i=0;i < NUMBER_OF_THREADS; i++) {
			int startIndex = i * (1000/NUMBER_OF_THREADS);
			int endIndex = (i+1) * (1000/NUMBER_OF_THREADS);
			
			Callable<Long> callable = new ArrayTaskFuture(vals, startIndex, endIndex);
			futureValues[i] = executor.submit(callable);
		}
		
		for(int i=0;i<NUMBER_OF_THREADS;i++) {
			try {
				System.out.println(futureValues[i].get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE,
							TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
