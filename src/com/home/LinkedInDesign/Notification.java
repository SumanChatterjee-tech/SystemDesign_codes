package com.home.LinkedInDesign;

import java.util.ArrayList;
import java.util.List;

import com.home.OvserverDesignPattern.Observer;

public class Notification implements Subject{

	List<Observers> listOfObservers = new ArrayList<>();
	private String message;
	
	@Override
	public void addObserver(Observers obs) {
		listOfObservers.add(obs);
		
	}

	@Override
	public void removeObserver(Observers obs) {
		listOfObservers.remove(obs);
		
	}

	@Override
	public void notifyObserver() {
		for(Observers obs : listOfObservers) {
			obs.getUpdate(message);
		}
		
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
