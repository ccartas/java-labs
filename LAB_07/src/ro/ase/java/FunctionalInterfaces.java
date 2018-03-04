package ro.ase.java;

public class FunctionalInterfaces {
	
	public static void main(String[] args) {
		
		
		ComputingType add = (a,b) -> a + b;
		ComputingType decr = (a,b) -> a - b;
		ComputingType prod = (a,b) -> {
			return a*b;
		};
		ComputingTypeImpl type = new ComputingTypeImpl();
		System.out.println(type.compute(70, 50, add));
		System.out.println(type.compute(20, 10, decr));
		System.out.println(type.compute(30, 10, prod));
		
	}
}
