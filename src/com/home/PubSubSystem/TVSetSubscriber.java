package com.home.PubSubSystem;

public class TVSetSubscriber implements Subscriber{

	@Override
	public void getMessage(Message message) {
		System.out.println("The TV Subscriber recieves "+ message);
	}

}
