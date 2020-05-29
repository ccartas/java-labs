package ro.ase.java.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class SumCalculatorThreads {
	private ExecutorService executor;
	private int numberOfThreads;
	private List<Callable<Long>> tasks;
	private List<Future<Long>> taskResults;
	
	public SumCalculatorThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
		this.executor = Executors.newFixedThreadPool(this.numberOfThreads);
	}
	
	public void setTasks(List<Callable<Long>> tasks) {
		this.tasks = tasks;
		this.taskResults = new ArrayList<Future<Long>>(this.tasks.size());
	}
	
	public long getResult() throws InterruptedException, ExecutionException {
		long startTime = System.currentTimeMillis();
		long sum = 0;
		for(Callable<Long> task : this.tasks) {
			this.taskResults.add(this.executor.submit(task));
		}
		this.executor.shutdown();
		this.executor.awaitTermination(0, TimeUnit.SECONDS);
		for(Future<Long> futureResult : this.taskResults) {
			sum += futureResult.get();
		}
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Parallel execution took: %d ms", endTime-startTime));
		return sum;
	}
}
