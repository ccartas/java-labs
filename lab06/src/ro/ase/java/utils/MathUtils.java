package ro.ase.java.utils;

import ro.ase.java.interfaces.MathOperation;
import ro.ase.java.interfaces.MathOperationFunctional;

public class MathUtils {

	public double getMathOperationResult(int a, int b, MathOperation operation) {
		return operation.doMathOperation(a, b);
	}
	
	public double getMathOperationResultFunctional(int a, int b, MathOperationFunctional operation) {
		return operation.doMathOperationFunctional(a, b);
	}
}
