package ro.ase.java.tcp.models;

import java.io.Serializable;

public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String sender;
	private String message;
	
	public Message(String sender, String message) {
		this.sender = sender;
		this.message = message;
	}
	
	public String getSender() {
		return this.sender;
	}
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", this.sender, this.message);
	}
}
