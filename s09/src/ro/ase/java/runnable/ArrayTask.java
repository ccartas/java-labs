package ro.ase.java.runnable;

public class ArrayTask implements Runnable{
	private int[] values;
	
	private int startIndex;
	private int endIndex;
	
	private long sum;
	
	public ArrayTask(int[] values, int start, int end) {
		this.values = values;
		this.startIndex = start;
		this.endIndex = end;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long s = 0;
		for(int i = this.startIndex; i<this.endIndex;i++) {
			s += this.values[i];
		}
		this.sum = s;
	}
	
	public long getSum() {
		return this.sum;
	}

}
