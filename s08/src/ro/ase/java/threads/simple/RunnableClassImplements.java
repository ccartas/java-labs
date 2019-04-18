package ro.ase.java.threads.simple;

public class RunnableClassImplements implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Execution in thread: " + Thread.currentThread().getName());
	}

}
