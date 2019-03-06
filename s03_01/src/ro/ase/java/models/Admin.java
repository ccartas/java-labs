package ro.ase.java.models;

public class Admin extends User implements UserService{
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
	public void authenticate(String user, String password) {
		if(this.getUsername().equals(user) && this.getPassword().equals(password)) {
			System.out.println("Admin authenticated successfully.");
		} else {
			System.out.println("Bad credentials.");
		}
		
	}
}
