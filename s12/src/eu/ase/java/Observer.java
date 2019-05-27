package eu.ase.java;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class Observer implements Subscriber<HttpRequest>{

	private Subscription subscription;
	
	@Override
	public void onSubscribe(Subscription subscription) {
		// TODO Auto-generated method stub
		this.subscription = subscription;
		this.subscription.request(1);
	}

	@Override
	public void onNext(HttpRequest item) {
		// TODO Auto-generated method stub
		System.out.println("Processing"+item.getPayload());
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		// TODO Auto-generated method stub
		throwable.printStackTrace();
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		System.out.println("Processing done");
	}

}
