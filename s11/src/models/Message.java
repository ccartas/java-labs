package models;

import java.io.Serializable;

public class Message implements Serializable{
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
	
	public String getSender() {
		return this.sender;
	}
	public String getPayload() {
		return this.payload;
	}
}
