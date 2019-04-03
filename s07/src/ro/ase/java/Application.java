package ro.ase.java;

import java.io.Serializable;

import ro.ase.java.models.MathLibrary;
import ro.ase.java.models.Operation;
import ro.ase.java.models.OperationFunctional;

public class Application {
	public static void main(String[] args) {
		MathLibrary lib = new MathLibrary();
		System.out.println(lib.getResult(5, 6, new Operation() {
			
			@Override
			public double doOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		}));
		
		Operation add = new Operation() {
			
			@Override
			public double doOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
		
		Operation substract = new Operation() {
			
			@Override
			public double doOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a-b;
			}
		};
		System.out.println(lib.getResult(10, 5, add));
		System.out.println(lib.getResult(15, 10, substract));
		
		//Functional interfaces
		
		System.out.println(lib.getResultFunctional(10, 20, (a,b) -> {
			return a+b;
		}));
		
		OperationFunctional divide = (a, b) -> a/b;
		OperationFunctional product = (a, b) -> a * b;
		
		System.out.println(lib.getResultFunctional(10, 2, divide));
		System.out.println(lib.getResultFunctional(2, 5, product));
	}
}
