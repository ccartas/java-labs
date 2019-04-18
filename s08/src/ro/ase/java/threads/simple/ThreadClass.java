package ro.ase.java.threads.simple;

public class ThreadClass extends Thread{
	
	String name;
	
	public ThreadClass(String name) {
		super(name);
		this.name = name;
	}
	
	
	@Override
	public void run() {
		System.out.println("Execution in thread: " + name);
	}
	
}

