package ro.ase.java.models;

import ro.ase.java.interfaces.UserServiceA;
import ro.ase.java.interfaces.UserServiceB;

public class Customer extends User implements UserServiceA, UserServiceB {
	private String fullName;
	
	public Customer(String username, String password, String fullName) {
		super(username, password);
		this.fullName = fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return this.fullName;
	}

	@Override
	public void authenticate(String username, String password) {
		// TODO Auto-generated method stub
		if(username.equals("customer") && password.equals("p@ssw0rd")) {
			System.out.println("Authentication successfully done.");
		} else {
			System.out.println("Invalid credentials.");
		}
	}
}
