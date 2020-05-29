package ro.ase.java.models;

public class UserData implements AutoCloseable {
	private String username;
	private String authToken;
	
	public UserData(String username, String authToken) {
		this.username = username;
		this.authToken = authToken;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	public String getUsername() {
		return this.username;
	}
	public String getAuthToken() {
		return this.authToken;
	}

	@Override
	public void close() throws Exception {
		this.authToken = null;
		this.username = null;
		System.out.println("Resource was freed.");
	}
}
