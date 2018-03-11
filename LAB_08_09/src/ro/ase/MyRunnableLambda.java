package ro.ase;

public class MyRunnableLambda {
	
	public static void main(String[] args) {
		
		Runnable runnable = () -> {
			System.out.println("Hello world ! I'm a runnable class run by thread "
					+ Thread.currentThread().getName());
		};
		
		
		Thread t1 = new Thread(runnable, "t1 lambda");
		t1.start();
	}

}
