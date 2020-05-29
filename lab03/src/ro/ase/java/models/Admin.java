package ro.ase.java.models;

import ro.ase.java.interfaces.UserServiceA;
import ro.ase.java.interfaces.UserServiceB;

public class Admin extends User implements UserServiceA, UserServiceB, Cloneable {
	private String companyName;
	
	public Admin(String username, String password, String companyName) {
		super(username, password);
		this.companyName = companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyName() {
		return this.companyName;
	}

	@Override
	public void authenticate(String username, String password) {
		// TODO Auto-generated method stub
		if(username.equals("admin") && password.equals("@dmin")) {
			System.out.println("Authentication successfully done.");
		} else {
			System.out.println("Invalid credentials.");
		}
	}
	
	@Override
	public Admin clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Admin a = (Admin) super.clone();
		a.setUsername(this.getUsername());
		a.setPassword(this.getPassword());
		a.setCompanyName(this.getCompanyName());
		return a;
	}
	
	
}
