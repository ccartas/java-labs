package ro.ase.java;

import ro.ase.java.interfaces.MathOperation;
import ro.ase.java.interfaces.MathOperationFunctional;
import ro.ase.java.utils.AddOperation;
import ro.ase.java.utils.MathUtils;

public class Application {
	public static void main(String[] args) {
		MathUtils mathUtils = new MathUtils();
		MathOperation addOperation = new AddOperation();
		System.out.println(mathUtils.getMathOperationResult(10, 20, addOperation));
		System.out.println(mathUtils.getMathOperationResult(20, 30, new MathOperation() {
			
			@Override
			public double doMathOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		}));
		
		MathOperation addOp = new MathOperation() {
			
			@Override
			public double doMathOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
		
		MathOperation substractOp = new MathOperation() {
			
			@Override
			public double doMathOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a-b;
			}
		};
		
		MathOperation multiplyOp = new MathOperation() {
			
			@Override
			public double doMathOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a*b;
			}
		};
		
		MathOperation divideOp = new MathOperation() {
			
			@Override
			public double doMathOperation(int a, int b) {
				// TODO Auto-generated method stub
				return a/b;
			}
		};
		
		System.out.println("Adunare: " + mathUtils.getMathOperationResult(20, 10, addOp));
		System.out.println("Diferenta: " + mathUtils.getMathOperationResult(20, 10, substractOp));
		System.out.println("Inmultire: " + mathUtils.getMathOperationResult(20, 10, multiplyOp));
		System.out.println("Impartire: " + mathUtils.getMathOperationResult(20, 10, divideOp));
		
		
		System.out.println(mathUtils.getMathOperationResultFunctional(10, 20, 
				(a, b) -> {
					return a+b;
				}
		));
		
		System.out.println(mathUtils.getMathOperationResult(10, 20, 
				(a, b) -> {
					return a+b;
				}
		));
		
		/**
		 * double doMathOperationFuncational(int a, int b) {
		 * 	return a + b;
		 * }
		 * 
		 * a -> a/2;
		 */
		MathOperationFunctional addOpF = (a, b) -> a+b;
		MathOperationFunctional substractOpF = (a, b) -> a - b;
		MathOperationFunctional multiplyOpF = (a, b) -> a * b;
		MathOperationFunctional divideOpF = (a, b) -> a / b;
		
		System.out.println("Adunare: " + mathUtils.getMathOperationResultFunctional(20, 10, addOpF));
		System.out.println("Diferenta: " + mathUtils.getMathOperationResultFunctional(20, 10, substractOpF));
		System.out.println("Inmultire: " + mathUtils.getMathOperationResultFunctional(20, 10, multiplyOpF));
		System.out.println("Impartire: " + mathUtils.getMathOperationResultFunctional(20, 10, divideOpF));
		
	}
}
