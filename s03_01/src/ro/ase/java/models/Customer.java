package ro.ase.java.models;

public class Customer extends User implements UserService{
	private String completeName;
	
	public Customer(String username, String password, String completeName) {
		super(username, password);
		this.completeName = completeName;
	}
	
	public void setCompleteName(String name) {
		this.completeName = name;
	}
	
	public String getCompleteName() {
		return this.completeName;
	}

	@Override
	public void authenticate(String user, String password) {
		if(this.getUsername().equals(user) && this.getPassword().equals(password)) {
			System.out.println("Customer authenticated successfully.");
		} else {
			System.out.println("Bad credentials.");
		}
	}
}
