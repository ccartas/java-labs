package ro.ase;

class MyCustonRunnable implements Runnable{
	private String message;

	public MyCustonRunnable(String message) {
		this.message = message;
	}

	@Override
	public void run() {
		System.out.println("MyCustonRunnable says " + message + " from thread " 
								+ Thread.currentThread().getName());
	}
}