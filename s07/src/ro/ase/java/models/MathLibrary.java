package ro.ase.java.models;

public class MathLibrary {

	public double getResult(int a, int b,Operation operation) {
		return operation.doOperation(a, b);
	}
	
	public double getResultFunctional(int a, int b, OperationFunctional func) {
		return func.operationFunctional(a, b);
	}
	
}
