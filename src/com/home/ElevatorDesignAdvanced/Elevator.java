package com.home.ElevatorDesignAdvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Elevator implements Runnable{
	int id;
	int currentFloor;
	ElevatorState state;
	boolean isRunning = true;
	TreeSet<Integer> upReuest;
	TreeSet<Integer> downRequest;
	List<ElevatorObserver> observers = new ArrayList<>();
	
	public Elevator(int id) {
		super();
		this.id = id;
		 this.currentFloor = 1;
	        this.upReuest = new TreeSet<>();
	        this.downRequest = new TreeSet<>((a, b) -> b - a);
	        this.state = new IdleState();
	}
	
	 // --- Observer Pattern Methods ---
    public void addObserver(ElevatorObserver observer) {
        observers.add(observer);
        observer.update(this); // Send initial state
    }

    public void notifyObservers() {
        for (ElevatorObserver observer : observers) {
            observer.update(this);
        }
    }
    
	public TreeSet<Integer> getUpReuest() {
		return upReuest;
	}

	public void setUpReuest(TreeSet<Integer> upReuest) {
		this.upReuest = upReuest;
	}

	public TreeSet<Integer> getDownRequest() {
		return downRequest;
	}

	public void setDownRequest(TreeSet<Integer> downRequest) {
		this.downRequest = downRequest;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int i) {
		this.currentFloor = i;
	}

	public ElevatorState getState() {
		return state;
	}

	public void setState(ElevatorState state) {
		this.state = state;
	}

	public void move() {
		state.move(this);
	}

	public synchronized void addRequest(Request request) {
		state.addRequest(this, request);
	}
	
	public Direction getDirection() { return state.getDirection(); }
	
	@Override
	public void run() {
		while(isRunning){
			move();
			try {
				Thread.sleep(1000); // Simulate movement time
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void stopElevator() {
		this.isRunning=false;
	}

}
