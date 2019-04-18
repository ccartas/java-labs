package ro.ase.java.callable;

import java.util.concurrent.Callable;

public class ArrayTaskFuture implements Callable<Long> {
	
	private int[] values;
	private int startIndex;
	private int endIndex;
	
	public ArrayTaskFuture(int[] values, int start, int end) {
		this.values = values;
		this.startIndex = start;
		this.endIndex = end;
	}
	
	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		long s = 0;
		for(int i = this.startIndex;i < this.endIndex; i++) {
			s += values[i];
		}
		return Long.valueOf(s);
	}

}
