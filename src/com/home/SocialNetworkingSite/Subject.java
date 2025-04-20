package com.home.SocialNetworkingSite;

public interface Subject {
	void subscribe(Observer observer);

	void unsubscribe(Observer observer);

	void notifyObservers(Notification notification);
}
