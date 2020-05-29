package ro.ase.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import ro.ase.java.utils.SumCalculator;
import ro.ase.java.utils.SumCalculatorThreads;
import ro.ase.java.utils.SumTask;

public class Application {
	public static final int NUMBER_OF_THREADS = 8;
	public static final int NUMBER_OF_ELEMENTS = 2000000000;
	public static void main(String[] args) {
		/*
		Thread t1 = new Thread(() ->  {
			System.out.println("execution on thread");
		});
		
		t1.start();
		*/
		/*
		//Exemplu basic ExecutorService cu Runnable si Future
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		Runnable r1 = () -> {
			System.out.println(String.format("Executing a task from %s", Thread.currentThread().getName()));
		};
		Callable<Integer> c1 = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				int sum = 0;
				for(int i = 0; i < 30; i++) {
					sum += i;
				}
				return sum;
			}
		};
		service.submit(r1);
		Future<Integer> result = service.submit(c1);
		// Blochez executia din thread-ul principal si astept ca toate taskurile sa fie executate
		service.shutdown();
		try {
			service.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//while(!service.isTerminated()) {}
		System.out.println("Instruction from main thread");
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		int chunkSize = NUMBER_OF_ELEMENTS / NUMBER_OF_THREADS;
		List<Callable<Long>> tasks = new ArrayList<Callable<Long>>(NUMBER_OF_THREADS);
		for(int i = 0; i < NUMBER_OF_THREADS; i++) {
			SumTask task = new SumTask(chunkSize * i, chunkSize * (i+1));
			tasks.add(task);
		}
		SumCalculatorThreads sumCalculator = new SumCalculatorThreads(NUMBER_OF_THREADS);
		sumCalculator.setTasks(tasks);
		System.out.println(SumCalculator.computeSum(NUMBER_OF_ELEMENTS));
		try {
			System.out.println(sumCalculator.getResult());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
