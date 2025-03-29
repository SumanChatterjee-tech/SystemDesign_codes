package com.home.PubSubSystem;

import java.util.ArrayList;
import java.util.List;

public class Topic {

	String name;
	List<Subscriber> subscribers;

	public Topic(String name) {
		this.name = name;
		this.subscribers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addSubscriber(Subscriber subscriber) {
		subscribers.add(subscriber);
	}

	public void removeSubscriber(Subscriber subscriber) {
		subscribers.remove(subscriber);
	}
	
    public void publish(Message message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.getMessage(message);
        }
    }
}
