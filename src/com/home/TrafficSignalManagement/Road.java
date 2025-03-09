package com.home.TrafficSignalManagement;

import java.util.*;

public class Road implements TrafficSignalObserver {

	List<Vehicle> vehicles = new ArrayList<>();
	String name;
	TrafficSignal tiTrafficSignal;

	public Road(String name, TrafficSignal tiTrafficSignal) {
		this.name = name;
		this.tiTrafficSignal = tiTrafficSignal;
		this.tiTrafficSignal.addObserver(this);
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TrafficSignal getTiTrafficSignal() {
		return tiTrafficSignal;
	}

	public void setTiTrafficSignal(TrafficSignal tiTrafficSignal) {
		this.tiTrafficSignal = tiTrafficSignal;
	}

	@Override
	public void update(Signal signal) {
		// TODO Auto-generated method stub
		System.out.println("Road " + name + " signal changed to: " + signal);
		for (Vehicle vehicle : vehicles) {
			vehicle.update(signal);
		}
	}

}
