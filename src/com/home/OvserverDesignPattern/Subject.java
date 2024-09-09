package com.home.OvserverDesignPattern;

public interface Subject {

	void addObserver(Observer obs);
	void removeObserver(Observer obs);
	void notifyObserver();
}
