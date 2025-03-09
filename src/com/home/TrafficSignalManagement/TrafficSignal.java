package com.home.TrafficSignalManagement;

import java.util.*;

public class TrafficSignal {

	private List<TrafficSignalObserver> trafficObservers = new ArrayList<>();
	private Signal signal;

	public Signal getSignal() {
		return signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
		notifyObservers();
	}

	public void addObserver(TrafficSignalObserver observer) {
		trafficObservers.add(observer);
	}

	public void removeObserver(TrafficSignalObserver observer) {
		trafficObservers.remove(observer);
	}
	
	public void notifyObservers() {
		for(TrafficSignalObserver observers: trafficObservers) {
			observers.update(signal);
		}
	}

}
