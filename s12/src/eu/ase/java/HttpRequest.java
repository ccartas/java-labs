package eu.ase.java;

import java.util.HashMap;
import java.util.List;

public class HttpRequest {
	private HashMap<String, String> httpHeaders;
	private String payload;
	
	public HttpRequest(HashMap<String, String> headers, String payload) {
		this.httpHeaders = headers;
		this.payload = payload;
	}
	
	public HashMap<String, String> getHeaders(){
		return this.httpHeaders;
	}
	
	public String getPayload() {
		return this.payload;
	}
}
