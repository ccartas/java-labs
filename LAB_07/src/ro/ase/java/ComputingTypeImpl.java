package ro.ase.java;

public class ComputingTypeImpl {
	
	public int compute(int a, int b, ComputingType type) {
		return type.operation(a, b);
	}
}
