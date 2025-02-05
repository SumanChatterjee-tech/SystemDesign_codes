package com.home.DesignAnAlertSystem_ObserverDesign;

import java.util.*;

public class AlertManager {

	private List<Subscriber> subscribers = new ArrayList<>();
	
    public void register(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unregister(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers(Alert alert) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveAlert(alert);
        }
    }
}
