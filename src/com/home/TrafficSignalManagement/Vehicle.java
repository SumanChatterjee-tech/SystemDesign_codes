package com.home.TrafficSignalManagement;

public class Vehicle implements TrafficSignalObserver{

	String name;
	
	public Vehicle(String name) {
		this.name = name;
	}

	@Override
	public void update(Signal signal) {
		switch(signal) {
		  case GREEN: System.out.println("Start vehicle"); break;
		  case YELLOW: System.out.println("Slow vehicle"); break;
		  case RED: System.out.println("Stop vehicle"); break;
		}
		
	}
	
	
}
