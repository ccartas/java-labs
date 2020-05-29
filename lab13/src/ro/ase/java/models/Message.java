package ro.ase.java.models;

import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String sender;
	private String payload;
	
	public Message(String sender, String payload) {
		this.sender = sender;
		this.payload = payload;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", this.sender, this.payload);
	}
}
