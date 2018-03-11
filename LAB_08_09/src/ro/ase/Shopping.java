package ro.ase;

public class Shopping extends Thread{

    static int accountDebit = 20;
    private String name;
    private static Object lock = new Object();
    
    public Shopping(String name) {
		super(name);
		this.name = name;
	}
    
    @Override
    public void run() {
    	for(int i=0; i < 200; i++){
    		synchronized (lock) {
    			withdraw(4);
			}
    	}
    }
    
    private void withdraw(int sum){
		if(accountDebit > 0){
			try {
				sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
	    	accountDebit -= sum;
    		System.out.println(name + " consumed " + sum + " total debit: " + accountDebit);
    		
    	}
    }
    
    
	public static void main(String[] args) {
        Shopping s1 = new Shopping("wife");
        Shopping s2 = new Shopping("husband");
        
        s1.start();
        s2.start();
        
        
    }
    
}
