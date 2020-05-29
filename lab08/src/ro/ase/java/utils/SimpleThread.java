package ro.ase.java.utils;

public class SimpleThread extends Thread {
	private String name;
	
	public SimpleThread(String name) {
		super(name);
		this.name = name;
	}
	
	@Override
	public void run() {
		System.out.println("Executing thread: " + this.name);
	}

}
