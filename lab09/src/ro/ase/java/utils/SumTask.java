package ro.ase.java.utils;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Long> {
	private int startIndex;
	private int endIndex;
	
	public SumTask(int startIndex, int endIndex) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long sum = 0;
		for(int i = this.startIndex; i < this.endIndex; i++) {
			if(i != 0) {
				sum += (i * i)/i;	
			}
		}
		return sum;
	}

}
