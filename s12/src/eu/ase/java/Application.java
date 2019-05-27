package eu.ase.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.SubmissionPublisher;

public class Application {
	
	public static void main(String[] args) {
		HashMap<String, String> headers = new HashMap();
		headers.put("Content-Type","application/json");
		HttpRequest req1 = new HttpRequest(headers, "Hello");
		HttpRequest req2 = new HttpRequest(headers, "Hello");
		List<HttpRequest> requests = new ArrayList<HttpRequest>();
		requests.add(req1);
		requests.add(req2);
		
		SubmissionPublisher<HttpRequest> publisher = new SubmissionPublisher<HttpRequest>();
		Observer observer = new Observer();
		publisher.subscribe(observer);
		
		requests.stream().forEach(request -> publisher.submit(request));
		
		try {
			Thread.sleep(2000);
			publisher.close();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
