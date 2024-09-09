package com.home.OvserverDesignPattern;

import java.util.*;

public class WeatherStationObserver implements Subject {

	List<Observer> listOfObservers = new ArrayList<>();
	private String message;
	
	@Override
	public void addObserver(Observer obs) {
		listOfObservers.add(obs);
		
	}

	@Override
	public void removeObserver(Observer obs) {
		listOfObservers.remove(obs);
		
	}

	@Override
	public void notifyObserver() {
		for(Observer obs : listOfObservers) {
			obs.update(message);
		}
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
