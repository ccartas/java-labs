package ro.ase.java.models;

public class User {
	private String username;
	private String password;
	
	public User(String user, String pass) {
		this.username = user;
		this.password = pass;
	}
	
	public void setUsername(String user) {
		this.username = user;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
}
