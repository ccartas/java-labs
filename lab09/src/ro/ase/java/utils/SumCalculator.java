package ro.ase.java.utils;

public class SumCalculator {
	public static long computeSum(int n) {
		long startingTime = System.currentTimeMillis();
		long sum = 0;
		for(int i = 0; i < n; i++) {
			if(i != 0) {
				sum += (i * i)/i;	
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Sum of %d numbers took: %d ms", n, endTime - startingTime));
		return sum;
	}
}
