package com.home.TrafficSignalManagement;

public class EmergencyVehicle implements TrafficSignalObserver{

	private final TrafficController controller;
    private final Road road;
    
    public EmergencyVehicle(TrafficController controller, Road road) {
    	this.controller = controller;
    	this.road = road;
    }
	
	@Override
	public void update(Signal signal) {
		// TODO Auto-generated method stub
		controller.overrideSignal(road.getTiTrafficSignal(), Signal.GREEN);
	}
}
